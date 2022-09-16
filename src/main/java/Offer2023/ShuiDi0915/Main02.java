package Offer2023.ShuiDi0915;


public class Main02{
    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        String sum = sum(a, b);
        System.out.println(sum);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 大整数求和
     *
     * @param numA string字符串 
     * @param numB string字符串 
     * @return string字符串
     */
    public static String sum (String numA, String numB) {
        // write code here
        StringBuilder stringB = new StringBuilder();
        StringBuilder stringA = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int length = Math.max(numA.length(),numB.length());
        int la = numA.length();
        int lb = numB.length();
        if(la < length){
            for(int i = 0; i < length - la; i++){
                stringA.append("0");
            }
            stringA.append(numA);
            stringB.append(numB);
        }else if(lb < length){
            for(int i = 0; i < length - lb; i++){
                stringB.append("0");
            }
            stringB.append(numB);
            stringA.append(numA);
        }else{
            stringB.append(numB);
            stringA.append(numA);
        }
        StringBuilder reverseA = stringA.reverse();
        StringBuilder reverseB = stringB.reverse();
        boolean jin = false;
        for(int i = 0; i < length; i++){
            int c1 = Integer.parseInt(String.valueOf(reverseA.charAt(i)));
            int c2 = Integer.parseInt(String.valueOf(reverseB.charAt(i)));
            int temp = 0;
            if(jin){
                temp = c1 + c2 + 1;
                if(temp >= 10){
                    temp = temp % 10;
                    jin = true;
                }else{
                    jin = false;
                }
            }else{
                temp = c1 + c2;
                if(temp >= 10){
                    temp = temp % 10;
                    jin = true;
                }else{
                    jin = false;
                }
            }
            res.append(temp);
            if(jin && i == length - 1){
                res.append("1");
            }
        }
        return res.reverse().toString();
    }
}