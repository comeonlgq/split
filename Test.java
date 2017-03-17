


public class Test {
	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		SyncopateGraphAndSentence syncopateGraphAndSentence = new SyncopateGraphAndSentence(
				"F:\\ProgramExam\\intelij_project\\split\\bin\\ok.txt");
		SynWordsByIK synWordsByIK = new SynWordsByIK(syncopateGraphAndSentence
				.getSourceStr());
		String syncopateWordStr = synWordsByIK.getNoSameSegResult();
		System.out.println("词元总数-----------"
				+ syncopateWordStr.split("/").length);
		//System.out.println("kkk=="+syncopateWordStr);
		Syncopate syncopate = new Syncopate(syncopateGraphAndSentence,
				syncopateWordStr);
		FrequencySynWords frequencySynWords = new FrequencySynWords(syncopate,
				syncopateWordStr.split("/").length);
		
		GraphSentenceConformity craphSentenceConformity = new GraphSentenceConformity(
				syncopate, frequencySynWords, syncopateGraphAndSentence);
		System.out.println("--------------摘要结果--------------------");
		System.out.println(craphSentenceConformity.getAutoSummaryResult());
		Long end = System.currentTimeMillis();
		System.out.println("运行时间-----------" + (end - start) + "毫秒����");
	}
}

