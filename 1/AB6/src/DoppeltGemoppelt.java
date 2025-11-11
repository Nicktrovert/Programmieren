import java.util.Arrays;

public class DoppeltGemoppelt {
    public static void main(String[] args) {
        /*
                                                     ,--,  ,.-.
               ,                   \,       '-,-`,'-.' | ._
              /|           \    ,   |\         }  )/  / `-,',
              [ ,          |\  /|   | |        /  \|  |/`  ,`
              | |       ,.`  `,` `, | |  _,...(   (      .',
              \  \  __ ,-` `  ,  , `/ |,'      Y     (   /_L\
               \  \_\,``,   ` , ,  /  |         )         _,/
                \  '  `  ,_ _`_,-,<._.<        /         /
                 ', `>.,`  `  `   ,., |_      |         /
                   \/`  `,   `   ,`  | /__,.-`    _,   `\
               -,-..\  _  \  `  /  ,  / `._) _,-\`       \
                \_,,.) /\    ` /  / ) (-,, ``    ,        |
               ,` )  | \_\       '-`  |  `(               \
              /  /```(   , --, ,' \   |`<`    ,            |
             /  /_,--`\   <\  V /> ,` )<_/)  | \      _____)
       ,-, ,`   `   (_,\ \    |   /) / __/  /   `----`
      (-, \           ) \ ('_.-._)/ /,`    /
      | /  `          `/ \\ V   V, /`     /
   ,--\(        ,     <_/`\\     ||      /
  (   ,``-     \/|         \-A.A-`|     /
 ,>,_ )_,..(    )\          -,,_-`  _--`
(_ \|`   _,/_  /  \_            ,--`
 \( `   <.,../`     `-.._   _,-`
         */
    }

    public static void say(String[] arr){
        for(String s : arr){
            System.out.println(s);
        }
    }

    public static void say(char[] arr){
        for(char c : arr){
            System.out.println(c);
        }
    }

    public static int add(int[] arr){
        return Arrays.stream(arr).sum();
    }

    public static double add(double[] arr){
        double sum = 0;
        for (double i : arr) {
            sum += i;
        }
        return sum;
    }

    public static String paint(String item, int times){
        return item.repeat(times);
    }

    public static String paint(int times, String item){
        return paint(item + "\n", times);
    }
}
