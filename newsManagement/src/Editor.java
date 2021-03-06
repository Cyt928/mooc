import java.util.*;


public class Editor extends Worker {

	public Editor() {

	}
	
	//初始化Editor
	public Editor(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = "Editor";
	}
		
	/**
     * 文本对齐
     *
     * 根据统计经验，用户在手机上阅读英文新闻的时候，
     * 一行最多显示32个字节（1个中文占2个字节）时最适合用户阅读。
     * 给定一段字符串，重新排版，使得每行恰好有32个字节，并输出至控制台
     * 首行缩进4个字节，其余行数左对齐，每个短句不超过32个字节，
     * 每行最后一个有效字符必须为标点符号
     *
     * 示例：
     * 
     * String：给定一段字符串，重新排版，使得每行恰好有32个字符，并输出至控制台首行缩进，其余行数左对齐，每个短句不超过32个字符。
     * 
     * 控制台输出:    
     *     给定一段字符串，重新排版，  
     * 使得每行恰好有32个字符，
     * 并输出至控制台首行缩进，         
     * 其余行数左对齐，
     * 每个短句不超过32个字符。
     * 
     */
    public void  textExtraction(String data){
        int length = 14;
        while (data.length() > 16) {
            for (int i = length; i >= 0; i--) {
                if ("，。？！".contains(data.substring(i, i + 1))) {
                    if (length == 14) {
                        System.out.println("    " + data.substring(0, i + 1));
                    } else {
                        System.out.println(data.substring(0, i + 1));
                    }
                    data = data.substring(i + 1);
                    break;
                }
            }
            length = 16;
        }
        System.out.println(data);
    }
    

    /**
     * 标题排序
     * 
     * 将给定的新闻标题按照拼音首字母进行排序，
     * 首字母相同则按第二个字母，如果首字母相同，则首字拼音没有后续的首字排在前面，如  鹅(e)与二(er)，
     *            以鹅为开头的新闻排在以二为开头的新闻前。
     * 如果新闻标题第一个字的拼音完全相同，则按照后续单词进行排序。如 新闻1为 第一次...  新闻2为 第二次...，
     *            则新闻2应该排在新闻1之前。
     * 示例：
     *            
     * newsList：我是谁；谁是我；我是我
     * 
     * return：谁是我；我是谁；我是我；
     *
     * @param newsList
     */
    public ArrayList<String> newsSort(ArrayList<String> newsList){
		return newsList;

    }


    /**
     * 热词搜索
     * 
     * 根据给定的新闻内容，找到文中出现频次最高的一个词语，词语长度最少为2（即4个字节），最多为10（即20个字节），且词语中不包含标点符号，可以出现英文，同频词语选择在文中更早出现的词语。
     * 
     * 示例：
     * 
     * String: 今天的中国，呈现给世界的不仅有波澜壮阔的改革发展图景，更有一以贯之的平安祥和稳定。这平安祥和稳定的背后，凝聚着中国治国理政的卓越智慧，也凝结着中国公安民警的辛勤奉献。
     * 
     * return：中国
     * 
     * @param newsContent
     */
    public String findHotWords(String newsContent){
        String[] content = newsContent.split("，。！？");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 2; i < 10; i++) {
            for (String s : content) {
                int len = s.length();

                if (i > len) break;

                for (int j = 0; j <= len - i; j++) {
                    String word = newsContent.substring(j, j + i);
                    if (!map.containsKey(word)) {
                        map.put(word, 1);
                    } else {
                        int val = map.get(word);
                        map.put(word, val + 1);
                    }
                }
            }
        }
        List<Map.Entry<String, Integer>> li = new ArrayList<>(map.entrySet());
        li.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return String.valueOf(li.get(0)).split("=")[0];
    }
    
    /**
    *
    *相似度对比
    *
    * 为了检测新闻标题之间的相似度，公司需要一个评估字符串相似度的算法。
    * 即一个新闻标题A修改到新闻标题B需要几步操作，我们将最少需要的次数定义为 最少操作数
    * 操作包括三种： 替换：一个字符替换成为另一个字符，
    *              插入：在某位置插入一个字符，
    *              删除：删除某位置的字符
    *  示例：
    *      中国队是冠军  -> 我们是冠军
    *      最少需要三步来完成。第一步删除第一个字符  "中"
    *                       第二步替换第二个字符  "国"->"我"
    *                       第三步替换第三个字符  "队"->"们"
    *      因此 最少的操作步数就是 3
    *
    * 定义相似度= 1 - 最少操作次数/较长字符串的长度
    * 如在上例中：相似度为  (1 - 3/6) * 100= 50.00（结果保留2位小数，四舍五入，范围在0.00-100.00之间）
    *
    *
    * @param title1
    * @param title2
    */
   public double minDistance(String title1, String title2){
       int len1 = title1.length();
       int len2 = title2.length();

       int[][] array = new int[len2 + 1][len1 + 1];
       for (int i = 0; i <= len1; i++) {
           array[0][i] = i;
       }
       for (int j = 0; j <= len2; j++) {
           array[j][0] = j;
       }

       for (int i = 1; i <= len1; i++) {
           for (int j = 1; j <= len2; j++) {
               int res = 0;
               char si = title1.charAt(i - 1);
               char sj = title2.charAt(j - 1);
               if (i >= 1 && j >= 1) {
                   int a = array[j - 1][i] + 1;
                   int b = array[j][i - 1] + 1;
                   int c = array[j - 1][i - 1] + ((si != sj) ? 1 : 0);
                   int temp = (a < b) ? a : b;
                   res = (temp < c) ? temp : c;
               }
               array[j][i] = res;
           }
       }
       float similarity = 1 - (float) array[len2][len1] / Math.max(title1.length(), title2.length());
       return similarity * 100;
   }
}
