import java.util.ArrayList;
import java.util.List;

/**
 * 根据词元信息统计每个词元出现的次数并且选出10个词元作为摘要组句
 *
 * @author CSU_KC
 *
 */

public class FrequencySynWords {
	private String[][] statSynWordFrequency;//包含频率信息的词元数组信息 格式：词元 起始位置 频率��

	private static int maxSynWords = ConstantManager.MaxSynWords;

	/**
	 * 构造函数
	 *
	 * @param syncopate
	 *            Syncopate对象
	 * @param noEchoWordCount
	 *            不重复词元个数
	 */

	public FrequencySynWords(Syncopate syncopate, int noEchoWordCount) {
		String[][] wordDegreeLocation = syncopate.getWordDegreeLocation();//到词元数组信息
		String[][] synWord = this.chooseSynWord(wordDegreeLocation,
				noEchoWordCount);
		String[][] maxTenSynWord = this.getMaxTenSynWord(synWord);//
		this.setStatSynWordFrequency(statSynWordFrequency(wordDegreeLocation,
				maxTenSynWord));
	}

	/**
	 * 得到 最终选择出的十个（或者小于十个）句子包含频率信息的词元数组信息
	 *
	 * @param wordDegreeLocation
	 *            所有词元数组信息
	 * @param maxTenSynWord
	 *            得到的前十个词元
	 * @return 返回包含频率信息的词元数组
	 */

	private String[][] statSynWordFrequency(String[][] wordDegreeLocation,
			String[][] maxTenSynWord) {
		// 存放统计频率后的十个词元
		// 格式：词元 起始位置 频率
		return synWordFrequency;
	}

	/**
	 * 获取选出十个词元的总出现频率
	 *
	 * @param maxTenSynWord
	 * @return
	 */

	private int getMaxTenSynWordCount(String[][] maxTenSynWord) {
		return maxTenSynWordCount;
	}

	/**
	 * 统计词元名称（不重复名称）和出现频率
	 *
	 * @param wordDegreeLocation
	 *            所有词元数组信息
	 * @param noEchoWordCount
	 *            不重复词元个数
	 * @return 返回选择的词元数组
	 */

	private String[][] chooseSynWord(String[][] wordDegreeLocation,
			int noEchoWordCount) {
		// 存放统计频率后的十个词元
		// 格式：词元 频率
		return synWord;
	}

	/**
	 * 在取出同一句子中的词元之后再进行选择maxSynWords(10)个关键字
	 *
	 * @param synWord
	 *            不重复词元数组
	 * @return 返回选中的词元数组
	 */

	private String[][] getMaxTenSynWord(String[][] synWord) {
			return maxTenSynWord;
	}

	public String[][] getStatSynWordFrequency() {
		return statSynWordFrequency;
	}

	public void setStatSynWordFrequency(String[][] statSynWordFrequency) {
		this.statSynWordFrequency = statSynWordFrequency;
	}

}
