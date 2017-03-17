import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 1 读取文件内容 2 将内容保存到一个字符串中 3 将分割出段落 4 分割出句子
 *
 * @author CSU_KC
 *
 */
public class SyncopateGraphAndSentence {
    private String sourceStr = "";// 存放从文件中得到的内容

    private int[][] paragraphs;// 存放分段信息数组

    private int[][] sentences;// 存放分句信息数组

    private String[] paragraphStr;// 存放分段内容

    private String[] sentencesStr;// 存放分句内容

    public SyncopateGraphAndSentence(String filePath) {
        String sourceStr = this.readNewsFile(filePath);

        this.setSourceStr(sourceStr);
        String[] splitParagraph = this.getParagraphs(this.getSourceStr());// 读取文件的时候用于分割段号

        int[][] paragraphInfo = this.getParagraphsInfo(splitParagraph);
        this.setParagraphs(paragraphInfo);// 将分割出的段落信息存放到paragraphs对象中
        int[][] sentenceInfo = this.getSentencesInParagraph(splitParagraph);
        this.setSentences(sentenceInfo);// 将分割出的句子信息存放到sentences对象中
        System.out.println("分段信息数组：" + this.getParagraphs().length);
        System.out.println("分句内容数组：" + this.getSentencesStr().length);
    }

    /**
     * 读取新闻文件并放到一个字符串中
     *
     * @param sourceFilePath
     *            源文件路径
     * @return 返回一个字符串
     */
    private String readNewsFile(String sourceFilePath) {
        StringBuffer sourceStr = new StringBuffer();
        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.isFile()) {
            System.out.println("请确保你选择的是一个文件或者文件路径要正确！");
            return "";
        }
        if (!sourceFile.exists()) {
            System.out.println("您的文件路径不正确，请查找文件是否存在！");
            return "";
        }
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(
                    sourceFile), "UTF-8");
            BufferedReader in = new BufferedReader(isr);
            String lineStr = in.readLine();
            while (lineStr != null) {
                if (!lineStr.trim().equals("")) {
                    if (lineStr != null) {
                        sourceStr.append(lineStr + "\r\n");// 读取的时添加\r\n是为了方便分段
                    }
                }
                lineStr = in.readLine();
            }
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceStr.toString();
    }

    /**
     * 将读取得到的字符串分割出段落内容
     *
     * @param sourceStr
     *            读取出的字符串内容
     * @return 返回一个段落字符数组
     */
    private String[] getParagraphs(String sourceStr) {
        String[] paragraphs = sourceStr.split("\r\n");
        this.setParagraphStr(paragraphs);
        return paragraphs;
    }

    /**
     * 根据分割出的段落字符串定位其在sourceStr中的位置
     *
     * @param splitParagraph
     *            分割出的段落的内容
     * @return 返回一个段落和原来内容的关系的数组
     */
    private int[][] getParagraphsInfo(String[] splitParagraph) {
        // 用于存放分段信息
        // 格式为：段号 段起 段尾
        int[][] paragraphInfo = new int[splitParagraph.length][3];// 用三列矩阵表示分段信息
        String sourceStr = this.getSourceStr();
        for (int i = 0; i < paragraphInfo.length; i++) {
            int paragraphBegin = sourceStr.indexOf(splitParagraph[i]);// 得到每段的起始位置

            int paragraphEnd = paragraphBegin + splitParagraph[i].length();// 得到每段的结束位置
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    paragraphInfo[i][j] = i + 1;// 段号
                } else if (j == 1) {
                    paragraphInfo[i][j] = paragraphBegin;// 每段的起始位置
                } else {
                    paragraphInfo[i][j] = paragraphEnd;// 每段的结束位置
                }
            }
        }
        return paragraphInfo;
    }

    /**
     * 根据分割出的段落字符串定位其在sourceStr中的位置
     *
     * @param splitParagraph
     *            分割出的字符串
     * @return 返回段落和句子关系的数组
     */
    private int[][] getSentencesInParagraph(String[] splitParagraph)
    {
        // 用于存放分句信息
        // 格式： 段号 句号 句子起始位置 句子结束位置    
		int[][] sentenceInfo = new int[getSentenceCount(splitParagraph)][4];// 用四列矩阵表示分句信息
        String sourceStr = this.getSourceStr();// 获得读取字符串的内容
        int sentenceIndex = 0;// 用于记录数组的下标
        StringBuffer sb = new StringBuffer();// 用于存放句子内容


        String[] sentences = getSentences(sb.toString());
        this.setSentencesStr(sentences);// 将分出的句子存储在sentencesStr对象中
        return sentenceInfo;
    }


    /**
     * 将分割出的句子放到一个String数组中
     *
     * @param sentenceStr
     *            所有句子内容的字符串
     * @return 返回的句子数组
     */
    private String[] getSentences(String sentenceStr) {
        return sentenceStr.split("\r\n");
    }

    /**
     * 获得要切分的句子总数
     *
     * @param splitParagraph
     *            切分出的段落字符
     * @return 返回句子总数
     */
    private int getSentenceCount(String[] splitParagraph) {
        return sentenceCount;
    }

    public int[][] getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(int[][] paragraphs) {
        this.paragraphs = paragraphs;
    }

    public String[] getParagraphStr() {
        return paragraphStr;
    }

    public void setParagraphStr(String[] paragraphStr) {
        this.paragraphStr = paragraphStr;
    }

    public int[][] getSentences() {
        return sentences;
    }

    public void setSentences(int[][] sentences) {
        this.sentences = sentences;
    }

    public String[] getSentencesStr() {
        return sentencesStr;
    }

    public void setSentencesStr(String[] sentencesStr) {
        this.sentencesStr = sentencesStr;
    }

    public String getSourceStr() {
        return sourceStr;
    }

    public void setSourceStr(String sourceStr) {
        this.sourceStr = sourceStr;
    }
}


