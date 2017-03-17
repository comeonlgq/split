
public class Syncopate {
	private String syncopateStr;// 用于存放分词结果��

	private String[] syncopateArray;// 将分词结果分割为词元数组�Ԫ����

	private String[][] wordDegreeLocation;// 存放词元出现位置信息

	public Syncopate(SyncopateGraphAndSentence synGraphAndSentence,
			String syncopateWordResult) {
		this.setSyncopateStr(syncopateWordResult);// 将上面手动分词结果放到字符串中保存�
		this.setSyncopateArray(this.splitSyncopateStr(syncopateWordResult));// 将保存的字符串结果分割为词元数组��������ַ�������ָ�Ϊ��Ԫ����

		int synStrAppearTimes = this
				.getAllSynStrAppearTimes(synGraphAndSentence);
		System.out.println("词元出现次数：" + synStrAppearTimes);
		String[][] wordDegreeLocation = this
				.getWordDegreeLocation(synGraphAndSentence);
		this.setWordDegreeLocation(wordDegreeLocation);
	}

	private String[] splitSyncopateStr(String syncopateStr) {
		return syncopateStr.split("/");
	}

	/**
	 * 用于存放词元出现位置信息
	 *
	 * @param synGraphAndSentence
	 *            SyncopateGraphAndSentence对象
	 * @return 返回词元相关信息字符数组
	 */

	private String[][] getWordDegreeLocation(
			SyncopateGraphAndSentence synGraphAndSentence) {
		return wordDegree;
	}

	/**
	 * 用于得到所有词元在所有句子中出现次数的总和
	 *
	 * @param synGraphAndSentence
	 *            SyncopateGraphAndSentence对象
	 * @return 返回出现总次数
	 */

	private int getAllSynStrAppearTimes(
			SyncopateGraphAndSentence synGraphAndSentence) {
		return synStrAppearTimes;
	}

	public String[] getSyncopateArray() {
		return syncopateArray;
	}

	public void setSyncopateArray(String[] syncopateArray) {
		this.syncopateArray = syncopateArray;
	}

	public String getSyncopateStr() {
		return syncopateStr;
	}

	public void setSyncopateStr(String syncopateStr) {
		this.syncopateStr = syncopateStr;
	}

	public String[][] getWordDegreeLocation() {
		return wordDegreeLocation;
	}

	public void setWordDegreeLocation(String[][] wordDegreeLocation) {
		this.wordDegreeLocation = wordDegreeLocation;
	}
}
