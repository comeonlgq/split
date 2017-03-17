
public class ConstantManager {

	public static final int MaxSynWords = 10;// 取的关键词个数(修改关键字控制数量)��

	public static final int FinalSentencesCount = 5;// 取的句子总数（控制生成文摘的句子数量）������

/**
 * 总权重计算公式：
 *
 * 总权重=频率权重*参数1 +位置权重*参数2+(距离参数倍数/距离权重)/（距离权重+距离权重补充值）
 *
 * 标题总权重=频率权重*FrequenceRight+TitleRight*PointRight+(DistanceRightMultiple/距离权重)*(距离权重+DistanceExponentExp)
 *
 * 第一段总权重=频率权重*FrequenceRight+FirstGraphRight*PointRight+(DistanceRightMultiple/距
 * 离权重)*(距离权重+DistanceExponentExp)
 *
 * 最后一段总权重=频率权重*FrequenceRight+LastGraphRight*PointRight+(DistanceRightMultiple/距离权重)*(距离权重+DistanceExponentExp)
 *
 * 其它段总权重=频率权重*FrequenceRight+(DistanceRightMultiple/距离权重)*(距离权重+DistanceExponentExp)
 */

public static final double TitleRight = 2;//标题权重

	public static final double FirstGraphRight = 1.5;//第一段权重

	public static final double LastGraphRight = 1.4;//最后一段权重 �

	public static final double FrequenceRight = 0.3;//频率权重参数

	public static final double PointRight = 0.5;//位置权重参数

	public static final double DistanceRight = 0.3;//距离权重参数��

	public static final double DistanceExponentExp = 10;//距离权重补充值

	public static final double DistanceRightMultiple = 1.0;// 距离权重倍数��
}

