

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 整合句子和词元关系，得到一个数组 格式：段号 句号 词元 起始位置 频率
 *
 * 计算总权重，并摘要
 *
 * @author CSU_KC
 *
 */

public class GraphSentenceConformity {

	private String autoSummaryResult;//存放摘要结果

	private static int finalSentencesCount = ConstantManager.FinalSentencesCount;

	public GraphSentenceConformity(Syncopate syncopate,
			FrequencySynWords frequencySynWords,
			SyncopateGraphAndSentence syncopateGraphAndSentence) {
		// 存放分句信息数组 格式：段号 句号 句子起始位置 句子结束位置��
		int[][] sentences = syncopateGraphAndSentence.getSentences();
		//包含频率信息的词元数组信息 格式：词元 起始位置 频率
		String[][] statSynWordFrequency = frequencySynWords
				.getStatSynWordFrequency();
		String[] paragraphStr = syncopateGraphAndSentence.getParagraphStr();// 将段落信息取过来以便得到段落总数��������Ϣȡ�����Ա�õ���������
		//段号,句子，词元，频率关系数组 格式：句号 词元 起始位置 频率�
		String[][] graphSentencesCon = this.getGraphSentencesConnection(
				sentences, statSynWordFrequency);
		// 格式为：句子，词元，总权重��
		String[][] synWordImportExponent = getSynWordImportExponent(
				graphSentencesCon, paragraphStr, sentences);
		//按照各个句子中出现词元总权重的总和选择摘要结果 ��
		String[][] sumNoSameSynWord = getNoSameSynWordBySum(synWordImportExponent);

		//按照各个句子中出现词元的最大权值进行摘要句子选择 �
		// String[][] maxNoSameSynWord =
		// getNoSameSynWordByMax(synWordImportExponent);

		String[] sentencesStr = syncopateGraphAndSentence.getSentencesStr();
		this.setAutoSummaryResult(autoSummaryResult(sumNoSameSynWord,
				sentencesStr));
	}

	/**
	 * 获得摘要结果
	 *
	 * @param maxNoSameSynWord
	 *            不重复词元数组
	 * @param sentencesStr
	 *            句子数组
	 * @return 返回摘要
	 */

	private String autoSummaryResult(String[][] maxNoSameSynWord,
			String[] sentencesStr) {
		return sb.toString();
	}

	/**
	 * 获得相同词元的权重总和数组
	 *
	 * @param synWordImportExponent
	 *            词元总权重等项数组 格式为：句子，词元，总权重
	 * @return 相同词元但是权重最大词元组成的数组
	 */

	private String[][] getNoSameSynWordBySum(String[][] synWordImportExponent) {
		// 格式为：句子，总权重�
		return maxNoSameSynWord;
	}

	/**
	 * 获得相同词元但是权重最大词元组成的数组
	 *
	 * @param synWordImportExponent
	 *            词元总权重等项数组 格式为：句子，词元，总权重
	 * @return 相同词元但是权重最大词元组成的数组
	 */

	private String[][] getNoSameSynWordByMax(String[][] synWordImportExponent) {
		return maxNoSameSynWord;
	}

	/**
	 * 获得句子总数
	 *
	 * @param synWordImportExponent
	 * @return
	 */

	private int getSynWordSentences(String[][] synWordImportExponent) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < synWordImportExponent.length; i++) {
			set.add(synWordImportExponent[i][0]);
		}
		return set.size();
	}

	/**
	 * 获得词的权重等项数组信息
	 *
	 * @param graphSentencesCon
	 *            格式为：段号,句子，词元，词元起始位置，频率 的数组
	 * @param sentences
	 *            格式：段号 句号 句子起始位置 句子结束位置
	 * @param paragraphStr
	 *            句子信息
	 * @return 返回包含权重的句子
	 */

	private String[][] getSynWordImportExponent(String[][] graphSentencesCon,
			String[] paragraphStr, int[][] sentences)
	{
		return synWordImportExponent;
	}

		/**
		 * 获得格式为：段号,句子，词元，起始位置，频率 的数组
		 *
		 * @param sentences
		 *            分句信息数组 格式为：段号 句号 句子起始位置 句子结束位置
		 * @param statSynWordFrequency
		 *            包含频率信息的词元数组信息 格式：词元 起始位置 频率
		 * @return 返回数组
		 */

		private String[][] getGraphSentencesConnection(int[][] sentences,String[][] statSynWordFrequency)
		{
			// 根据词元长度构造此数组
			//段号,句子，词元，起始位置，频率
		return graphSentencesCon;
	}

	public String getAutoSummaryResult() {
		return autoSummaryResult;
	}

	public void setAutoSummaryResult(String autoSummaryResult) {
		this.autoSummaryResult = autoSummaryResult;
	}
}

