import java.util.Arrays;

public class Accountant extends Worker {
	public String password;

	public Accountant() {

	}
	
	//初始化Accountant
	public Accountant(String name, int age, int salary, String password) {
        if (age < 18 || salary < 2000) {
            String message = "age must be greater than 18 and salary must be greater than 2000.";
            throw new IllegalArgumentException(message);
        }
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.password=password;
	}
	
    /**
     * 数字转换
     * 随着公司业务的开展，国际性业务也有相应的拓宽，
     * 会计们需要一个自动将数字转换为英文显示的功能。
     * 编辑们希望有一种简约的方法能将数字直接转化为数字的英文显示。
     * 
     * 给定一个非负整数型输入，将数字转化成对应的英文显示，省略介词and
     * 正常输入为非负整数，且输入小于2^31-1;
     * 如果有非法输入（字母，负数，范围溢出等），返回illegal
     * 
     * 示例：
     * 
     * number: 2132866842
     * return: "Two Billion one Hundred Thirty Two Million Eight Hundred Sixty Six Thousand Eight Hundred Forty Two"
     *
     * number：-1
     * return："illegal"
     * @param number
     */
    public  String numberToWords (String number) {
        while (number.startsWith("0")){
            number=number.substring(1);
        }
        String result = "";
        char[] chararray = number.toCharArray();
        for (char chr : chararray) {
            if (!Character.isDigit(chr)) {
                return "illegal";
            }
        }
        Long longNumber = Long.valueOf(number);
        if (longNumber > 2147483647 || longNumber < 0) {
            return "illegal";
        }
        //这一步判断是否数字为负数和范围溢出
        int whichThousand = 0;
        //这个变量用来表示是第几个千；第0个千什么都不加，第1个加上thousand，第2个million，第三个billion
        while (chararray.length > 0) {
            switch (whichThousand) {
                case 0:
                    break;
                case 1:
                    result = " Thousand" + result;
                    break;
                case 2:
                    result = " Million" + result;
                    break;
                case 3:
                    result = " Billion" + result;
                    break;
                default:
                    break;
            }
            whichThousand += 1;
            if (chararray.length == 1) {
                switch (chararray[0]) {
                    case '1':
                        result = "One" + result;
                        break;
                    case '2':
                        result = "Two" + result;
                        break;
                    case '3':
                        result = "Three" + result;
                        break;
                    case '4':
                        result = "Four" + result;
                        break;
                    case '5':
                        result = "Five" + result;
                        break;
                    case '6':
                        result = "Six" + result;
                        break;
                    case '7':
                        result = "Seven" + result;
                        break;
                    case '8':
                        result = "Eight" + result;
                        break;
                    case '9':
                        result = "Nine" + result;
                        break;
                    default:
                        break;

                }
                chararray = Arrays.copyOfRange(chararray, 0, chararray.length - 1);
            } else if (chararray.length == 2) {
                if (chararray[chararray.length - 2] == '1') {
                    //当这个两位为十几时单独讨论
                    switch (chararray[chararray.length - 1]) {
                        case '1':
                            result = "Eleven" + result;
                            break;
                        case '2':
                            result = "Twelve" + result;
                            break;
                        case '3':
                            result = "Thirteen" + result;
                            break;
                        case '4':
                            result = "Fourteen" + result;
                            break;
                        case '5':
                            result = "Fifteen" + result;
                            break;
                        case '6':
                            result = "Sixteen" + result;
                            break;
                        case '7':
                            result = "Seventeen" + result;
                            break;
                        case '8':
                            result = "Eighteen" + result;
                            break;
                        case '9':
                            result = "Nineteen" + result;
                            break;
                        case '0':
                            result = "Ten" + result;
                            break;
                        default:
                            break;
                    }
                } else  {
                    switch (chararray[chararray.length - 1]) {
                        case '1':
                            result = " One" + result;
                            break;
                        case '2':
                            result = " Two" + result;
                            break;
                        case '3':
                            result = " Three" + result;
                            break;
                        case '4':
                            result = " Four" + result;
                            break;
                        case '5':
                            result = " Five" + result;
                            break;
                        case '6':
                            result = " Six" + result;
                            break;
                        case '7':
                            result = " Seven" + result;
                            break;
                        case '8':
                            result = " Eight" + result;
                            break;
                        case '9':
                            result = " Nine" + result;
                            break;
                        default:
                            break;
                    }
                    switch (chararray[chararray.length - 2]) {
                        case '2':
                            result = "Twenty" + result;
                            break;
                        case '3':
                            result = "Thirty" + result;
                            break;
                        case '4':
                            result = "Forty" + result;
                            break;
                        case '5':
                            result = "Fifty" + result;
                            break;
                        case '6':
                            result = "Sixty" + result;
                            break;
                        case '7':
                            result = "Seventy" + result;
                            break;
                        case '8':
                            result = "Eighty" + result;
                            break;
                        case '9':
                            result = "Ninety" + result;
                            break;
                    }
                }
                chararray=Arrays.copyOfRange(chararray,0,chararray.length-2);
            }else {
                if (chararray[chararray.length - 2] == '1') {
                    //十几单独讨论
                    switch (chararray[chararray.length - 1]) {
                        case '1':
                            result = " Eleven" + result;
                            break;
                        case '2':
                            result = " Twelve" + result;
                            break;
                        case '3':
                            result = " Thirteen" + result;
                            break;
                        case '4':
                            result = " Fourteen" + result;
                            break;
                        case '5':
                            result = " Fifteen" + result;
                            break;
                        case '6':
                            result = " Sixteen" + result;
                            break;
                        case '7':
                            result = " Seventeen" + result;
                            break;
                        case '8':
                            result = " Eighteen" + result;
                            break;
                        case '9':
                            result = " Nineteen" + result;
                            break;
                        case '0':
                            result = " Ten" + result;
                            break;
                        default:
                            break;
                    }
                } else  {
                    switch (chararray[chararray.length - 1]) {

                        case '1':
                            result = " One" + result;
                            break;
                        case '2':
                            result = " Two" + result;
                            break;
                        case '3':
                            result = " Three" + result;
                            break;
                        case '4':
                            result = " Four" + result;
                            break;
                        case '5':
                            result = " Five" + result;
                            break;
                        case '6':
                            result = " Six" + result;
                            break;
                        case '7':
                            result = " Seven" + result;
                            break;
                        case '8':
                            result = " Eight" + result;
                            break;
                        case '9':
                            result = " Nine" + result;
                            break;
                        default:
                            break;
                    }
                    switch (chararray[chararray.length - 2]) {
                        case '2':
                            result = "Twenty" + result;
                            break;
                        case '3':
                            result = "Thirty" + result;
                            break;
                        case '4':
                            result = "Forty" + result;
                            break;
                        case '5':
                            result = "Fifty" + result;
                            break;
                        case '6':
                            result = "Sixty" + result;
                            break;
                        case '7':
                            result = "Seventy" + result;
                            break;
                        case '8':
                            result = "Eighty" + result;
                            break;
                        case '9':
                            result = "Ninety" + result;
                            break;
                    }
                }
                switch (chararray[chararray.length - 3]){
                    case '1':
                        result = "One Hundred" + result;
                        break;
                    case '2':
                        result = "Two Hundred" + result;
                        break;
                    case '3':
                        result = "Three Hundred" + result;
                        break;
                    case '4':
                        result = "Four Hundred" + result;
                        break;
                    case '5':
                        result = "Five Hundred" + result;
                        break;
                    case '6':
                        result = "Six Hundred" + result;
                        break;
                    case '7':
                        result = "Seven Hundred" + result;
                        break;
                    case '8':
                        result = "Eight Hundred" + result;
                        break;
                    case '9':
                        result = "Nine Hundred" + result;
                        break;
                    default:
                        break;
                }
                chararray=Arrays.copyOfRange(chararray,0,chararray.length-3);
            }


        }
        return result;
    }
    
    /**
     * 检验密码
     * 由于会计身份的特殊性，对会计的密码安全有较高的要求，
     * 会计的密码需要由8-20位字符组成；
     * 至少包含一个小写字母，一个大写字母和一个数字，不允许出现特殊字符；
     * 同一字符不能连续出现三次 (比如 "...ccc..." 是不允许的, 但是 "...cc...c..." 可以)。
     * 
     * 如果密码符合要求，则返回0;
     * 如果密码不符合要求，则返回将该密码修改满足要求所需要的最小操作数n，插入、删除、修改均算一次操作。
     *
     * 示例：
     * 
     * password: HelloWorld6
     * return: 0
     *
     * password: HelloWorld
     * return: 1
     * 
     * @param password
     */
    public  int checkPassword(){
        boolean containsUpperCase=false;
        //是否有大写字母
        boolean containsLowerCase=false;
        //是否有小写字母
        boolean containsDigit=false;
        //是否有数字
        int specialLetter=0;
        //特殊字符数

        int n=0;
        //总操作次数

        int length=password.length();

        char[] chars=password.toCharArray();
        for(char chr:chars){
            //判断了有无大小写，数字
            if(Character.isDigit(chr)){
                containsDigit=true;
                continue;
            }else if ((Character.isLetter(chr))){
                if (Character.isUpperCase(chr)){
                    containsUpperCase=true;
                    continue;
                }else {
                    containsLowerCase=true;
                    continue;
                }
            }else {
                specialLetter++;
            }
        }

        int[] repeatTimes=new int[password.length()];
        //这个数组用来记录到这个字母时，重复了几次，
        //比如avsssdwex，第三个s为3，第二个s为2

        repeatTimes[0]=0;
        for(int i=1;i<password.length();i++){
            if (chars[i]==chars[i-1]){
                repeatTimes[i]=repeatTimes[i-1]+1;
            }else {
                repeatTimes[i]=0;
            }
        }
        boolean repeatLessThanThree=true;
        for(int times:repeatTimes){
            if (times>=3){
                repeatLessThanThree=false;
                break;
            }
        }

        if (length>=8&& length<=20 && containsDigit&& containsLowerCase&&containsUpperCase&&repeatLessThanThree&&specialLetter==0){
            return 0;
        }

        int specialAdd=0;
        //特殊三大字符需要添加的总数（必须添加）
        if(!containsDigit){
            specialAdd++;
        }
        if (!containsLowerCase){
            specialAdd++;
        }
        if (!containsUpperCase){
            specialAdd++;
        }

        for(int i=0;i<password.length()-1;i++){
            if (repeatTimes[i]>=3&& repeatTimes[i+1]==0){
                n++;
                if (specialAdd!=0){
                    //插入字符可以用三大字符代替
                    specialAdd--;
                }
                length++;
            }
        }if (repeatTimes[password.length()-1]>=3){
            n++;
        }
        if (specialAdd!=0){
            n+=specialAdd;
            length+=specialAdd;
        }

        n-=specialLetter;
        //删除特殊字符
        length-=specialLetter;

        if (length<8){
            n+=(8-length);
        }else if (length>20){
            n+=(length-20);
        }

		return n;

    }
}
