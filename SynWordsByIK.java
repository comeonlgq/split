


import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


	/**
	 * ����IK�ִʶ����½��зִʴ���
	 * 
	 * @author CSU_KC
	 * 
	 */
	public class SynWordsByIK {
		private String noSameSegResult;// 存放切分出的不重复的词元

		public SynWordsByIK(String srcString) {
			System.out.println("Length = " + srcString.length());
			IKSegmenter ikSeg = new IKSegmenter(new StringReader(srcString),
					true);
			long begin = System.currentTimeMillis();
			String segResult = getSegResult(ikSeg);
			String noSameSegResult = getNoSameSegResult(segResult);
			this.setNoSameSegResult(noSameSegResult);
			long end = System.currentTimeMillis();
			System.out.println("分词耗时：" + (end - begin) + "毫秒 ");
		}

		/**
		 * 获得切分出的不重复的词元字符串
		 *
		 * @param segResult
		 * @return
		 */

		public String getNoSameSegResult(String segResult) {
			
			
			GetMiddleStr gstr=new GetMiddleStr();
			//String[] segArray = segResult.split("/");
			String[] segArray = gstr.getWords(segResult);
			String[] noSameSegResultBefore = new String[segArray.length];
			List<String> index = new ArrayList<String>();
			for (int i = 0; i < segArray.length; i++) {
				for (int j = i + 1; j < segArray.length; j++) {
					if (index.indexOf(segArray[i]) != -1) {
						continue;
					}
					noSameSegResultBefore[i] = segArray[i];
					index.add(segArray[i]);
					break;
				}
			}
			StringBuffer noSameSegResult = new StringBuffer();
			for (int i = 0; i < noSameSegResultBefore.length; i++) {
				if (noSameSegResultBefore[i] != null) {
					noSameSegResult.append(noSameSegResultBefore[i]).append("/");
				}
			}
			return noSameSegResult.toString();
		}

		/**
		 * 获得原始切分出的字符串（可能包含重复词元）
		 *
		 * @param ikSeg
		 * @return
		 */

		public String getSegResult(IKSegmenter ikSeg) {
			StringBuffer sb = new StringBuffer();
			try {
				Lexeme l = null;
				while ((l = ikSeg.next()) != null) {
					if (!l.toString().trim().equals("")) {
						sb.append(l.toString().trim()).append("/");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			//----------------------                    -//
			return sb.toString();
		}

		public String getNoSameSegResult() {
			return noSameSegResult;
		}

		public void setNoSameSegResult(String noSameSegResult) {
			this.noSameSegResult = noSameSegResult;
		}
	}

