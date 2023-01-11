import java.util.Stack;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
class EvaluateString {
    public static int evaluate(String expression)
    {
    char[] tokens = expression.toCharArray();
   
    Stack<Integer> values = new
    Stack<Integer>();
   
    Stack<Character> operators = new
    Stack<Character>();
   
    for (int i = 0; i < tokens.length; i++)
    {
   
    if (tokens[i] == ' ')
    continue;
   
    if (tokens[i] >= '0' && tokens[i] <= '9')
    {
    StringBuffer sbuf = new StringBuffer();
    while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
    sbuf.append(tokens[i++]);
    values.push(Integer.parseInt(sbuf.toString()));
    i--;
    }
   
    else if (tokens[i] == '(')
    operators.push(tokens[i]);
   
    else if (tokens[i] == ')')
    {
    while (operators.peek() != '(')
    values.push(applyOp(operators.pop(),
    values.pop(),
    values.pop()));
    operators.pop();
    }
    else if (tokens[i] == '+' ||
    tokens[i] == '-' ||
    tokens[i] == '*' ||
    tokens[i] == '/')
    {
    while (!operators.empty() && hasPrecedence(tokens[i], operators.peek()))
    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
    operators.push(tokens[i]);
    }
    }
   
    while (!operators.empty())
    values.push(applyOp(operators.pop(),
    values.pop(),
    values.pop()));
   
    return values.pop();
    }
   
    public class Memory{
        class Line_memory{
            short linenumber;
            String Line;
        }
        private int curr_line;
        private boolean mEOL,mEOF;
    }
   
    public static boolean hasPrecedence(char op1, char op2)
    {
    if (op2 == '(' || op2 == ')')
    return false;
    if ((op1 == '*' || op1 == '/') &&
    (op2 == '+' || op2 == '-'))
    return false;
    else
    return true;
    }
    public static int applyOp(char op,int b, int a)
    {
    switch (op)
    {
    case '+':
    return a + b;
    case '-':
    return a - b;
    case '*':
    return a * b;
    case '/':
    if (b == 0)
    throw new UnsupportedOperationException("Cannot divide by zero");
    return a / b;
    }
    return 0;
    }

    public static void main(String args[])
    throws IOException {
        Path filename = Path.of("C:\\Users\\15625\\Desktop\\sample.txt");
        String str = Files.readString(filename);
        Scanner sc = new Scanner(System.in);
        String[] arrOfStr = str.split("\n");
        String[] end_array = new String[1];
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("END".toLowerCase()) != -1 ){
                end_array[0] = "END";
            }
        int k = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("LET".toLowerCase()) != -1 )
            {
                k += 1;
            }
        int l = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("PRINT".toLowerCase()) != -1 )
            {
                l += 1;
            }
        int s_p = 0;
        String arr_p[] = new String[l];
        for (String a : arrOfStr){
            if ( a.toLowerCase().indexOf("PRINT".toLowerCase()) != -1 )
            {
                arr_p[s_p] = a;
                s_p += 1;
            }
        }
        if (k != 0){
        String arr[] = new String[k];
        int s = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("LET".toLowerCase()) != -1 )
            {
                arr[s] = a;
                s += 1;
            }
       
        String[] ch_arr = new String[arr.length];
        int ch_count = 0;
        for(String a:arr){
            String sty = "";
            for(int i=0;i<a.length();i++){
                if (i!=0&&i!=1){
                char c = a.charAt(i);
                sty += c;
            }}
        sty = sty.trim();
        ch_arr[ch_count] = sty;
        ch_count += 1;
        }
        int counter = 0;
        for (String d : ch_arr){
           String[] arrs = d.split(" ",2);
            for (String a : arrs)
            {
                if ( a.toLowerCase().indexOf("LET".toLowerCase()) == -1 ){
                    String[] arr_split = a.split(" ");
                    counter += 1;
                }
        }}
        String arr_num[] = new String[counter];
        String arr_letters[] = new String[counter];
        int arr_count = 0;
        for (String d : ch_arr){
           String[] arrs = d.split(" ",2);
            for (String a : arrs)
            {
                if ( a.toLowerCase().indexOf("LET".toLowerCase()) == -1 ){
                    String[] arr_split = a.split(" ");
                    arr_num[arr_count] = arr_split[2];
                    arr_letters[arr_count] = arr_split[0];
                    arr_count += 1;
                }
        }}
        String val = "";
        int c = 0;
        for(String a : arr_num){
            if ( a.toLowerCase().indexOf("+".toLowerCase()) != -1 ){
                val = a;
                c += 1;
            }
            else if ( a.toLowerCase().indexOf("-".toLowerCase()) != -1){
                val = a;
                c += 1;
            }
            else if ( a.toLowerCase().indexOf("*".toLowerCase()) != -1){
                 val = a;
                 c += 1;
            }
            else if ( a.toLowerCase().indexOf("/".toLowerCase()) != -1){
                val = a;
                c += 1;

            }
                    }
    if(c>0){
    String val_data = "";
    int str_length = 0;
    for (int i = 0; i < val.length(); i++){
        str_length += 1;
    }
    int val_count = 0;
    String val_array[] = new String[str_length];
    for (int i = 0; i < val.length(); i++){
        val_data = Character.toString(val.charAt(i));
        val_array[val_count] = val_data;
        val_count += 1;
    }
    for(int i=0;i<val_array.length;i++){
        for (int j=0; j < arr_letters.length; j++){
            if(val_array[i].equals(arr_letters[j])){
                val_array[i] = arr_num[j];
            }
        }
    }
    int final_value = 0;
    String final_str = "";
    for(int i=0; i<val_array.length;i++){
        final_str += val_array[i];
    }
    final_value = EvaluateString.evaluate(final_str);
    int index_val = (arr_num.length)-1;
    arr_num[index_val] = Integer.toString(final_value);
    int prnt_counter = 0;
    for(int i=0;i<arr_p.length;i++){
      prnt_counter += 1;
}
    String[] ch_prt = new String[prnt_counter];
        int ch_cnt = 0;
        for(String a:arr_p){
            String sty = "";
            for(int i=0;i<a.length();i++){
                if (i!=0&&i!=1){
                char cnt = a.charAt(i);
                sty += cnt;
            }}
        sty = sty.trim();
        ch_prt[ch_cnt] = sty;
        ch_cnt += 1;
        }
    int prnt_count = 0;
    String arr_pntr[] = new String[prnt_counter];
    for(int i=0;i<ch_prt.length;i++){
      String[] arrs_p = ch_prt[i].split(" ",0);
      arr_pntr[prnt_count] = arrs_p[1];
      prnt_count += 1;
    }
            for(int i=0;i<arr_pntr.length;i++){
                for (int j=0; j < arr_letters.length; j++){
                    if(arr_pntr[i].equals(arr_letters[j])){
                        arr_pntr[i] = arr_num[j];
                    }
                }
            }
    for(int i=0;i<arr_pntr.length;i++){
      arr_pntr[i] = arr_pntr[i].replaceAll("^\"|\"$", "");
    }
    String final_str_val = "";
    for(int i=0; i<arr_pntr.length;i++){
                final_str_val += arr_pntr[i];
            }
            System.out.println(final_str_val);
            }
}
    else{
        int k_val = 0;
        String[] arrOfStr_pr = str.split("\n");
        for (String a : arrOfStr_pr)
            if ( a.toLowerCase().indexOf("INPUT".toLowerCase()) != -1 )
            {
                k_val += 1;
            }
        int l_val = 0;
        String int_str = "";
        for (String a : arrOfStr_pr)
            if ( a.toLowerCase().indexOf("INTEGER".toLowerCase()) != -1 )
            {
                l_val += 1;
                int_str = "INTEGER";
            }
        int f_val = 0;
        for (String a : arrOfStr_pr)
            if ( a.toLowerCase().indexOf("if".toLowerCase()) != -1 )
            {
                f_val += 1;
            }
        int g_val = 0;
        for (String a : arrOfStr_pr)
            if ( a.toLowerCase().indexOf("goto".toLowerCase()) != -1 )
            {
                g_val += 1;
            }
        if (k_val != 0 && f_val == 0 && g_val == 0){
        String arr[] = new String[k_val];
        int s = 0;
        for (String a : arrOfStr_pr)
            if ( a.toLowerCase().indexOf("INPUT".toLowerCase()) != -1 )
            {
                arr[s] = a;
                s += 1;
            }
        int input_counter = 0;
        for(int i=0;i<arr.length;i++){
            input_counter += 1;
        }
        String[] ch_arr_int = new String[input_counter];
        int ch_count_int = 0;
        for(String a:arr){
            String sty_int = "";
            for(int i=0;i<a.length();i++){
                if (i!=0&&i!=1){
                char cntr = a.charAt(i);
                sty_int += cntr;
            }}
        sty_int = sty_int.trim();
        ch_arr_int[ch_count_int] = sty_int;
        ch_count_int += 1;
        }
        String arr_num_int[] = new String[input_counter];
        String arr_letters_int[] = new String[input_counter];
        int arr_count_int = 0;
        for (String d : ch_arr_int){
           String[] arrs = d.split(" ",2);
           arr_num_int[0] = arrs[1];
           arr_letters_int[0] = arrs[0];
        }
        int input_counter_print = 0;
        for(int i=0;i<arr_p.length;i++){
            input_counter_print += 1;
        }
        String[] ch_arr_int_print = new String[input_counter_print];
        int ch_count_int_print = 0;
        for(String a:arr_p){
            String sty_int_print = "";
            for(int i=0;i<a.length();i++){
                if (i!=0&&i!=1){
                char cntr_print = a.charAt(i);
                sty_int_print += cntr_print;
            }}
        sty_int_print = sty_int_print.trim();
        ch_arr_int_print[ch_count_int_print] = sty_int_print;
        ch_count_int_print += 1;
        }
        String arr_num_print[] = new String[ch_arr_int_print.length];
        String arr_letters_print[] = new String[ch_arr_int_print.length];
        int arr_count_print = 0;
        for (int i=0;i<1;i++){
           String[] arrs = ch_arr_int_print[i].split(" ",2);
        }
        int val_counter = 0;
        try{
        if (l_val != 0){
            String[] arrss = ch_arr_int_print[0].split(" ",2);
            System.out.println(arrss[1].replaceAll("^\"|\"$", ""));
            int a = sc.nextInt();
            val_counter += 1;
            arr_num_int[0] = Integer.toString(a);
        }}
        catch(Exception e){
            System.out.println("No input Provided");
        }
        if(val_counter!=0){
            String[] arrss = ch_arr_int_print[1].split(" ",2);
            String arrear = arrss[1].replaceAll("^\"|\"$", "");
            System.out.println(arrear+arr_num_int[0]);
        }
    }
        else if (k_val == 0 && f_val == 0 && g_val == 0){
            int prt_counter = 0;
        for(int i=0;i<arr_p.length;i++){
            prt_counter += 1;
        }
        String[] ch_arr_int_print_value = new String[prt_counter];
        int ch_count_int_print_value = 0;
        for(String a:arr_p){
            String sty_int_print_value = "";
            for(int i=0;i<a.length();i++){
                if (i!=0&&i!=1){
                char cntr_print_value = a.charAt(i);
                sty_int_print_value += cntr_print_value;
            }}
        sty_int_print_value = sty_int_print_value.trim();
        ch_arr_int_print_value[ch_count_int_print_value] = sty_int_print_value;
        ch_count_int_print_value += 1;
        }
        for (String d : ch_arr_int_print_value){
            String[] arrs_s = d.split(" ",2);
            System.out.println(arrs_s[1].replaceAll("^\"|\"$", ""));
        }
        }
        else if(k_val != 0 && f_val !=0 && g_val == 0){
        String arr[] = new String[k_val];
        int s = 0;
        for (String a : arrOfStr_pr)
            if ( a.toLowerCase().indexOf("INPUT".toLowerCase()) != -1 )
            {
                arr[s] = a;
                s += 1;
            }
        int input_counter = 0;
        for(int i=0;i<arr.length;i++){
            input_counter += 1;
        }
        String[] ch_arr_int = new String[input_counter];
        int ch_count_int = 0;
        for(String a:arr){
            String sty_int = "";
            for(int i=0;i<a.length();i++){
                if (i!=0&&i!=1){
                char cntr = a.charAt(i);
                sty_int += cntr;
            }}
        sty_int = sty_int.trim();
        ch_arr_int[ch_count_int] = sty_int;
        ch_count_int += 1;
        }
        String arr_num_int[] = new String[input_counter];
        String arr_letters_int[] = new String[input_counter];
        int arr_count_int = 0;
        for (int i=0;i<ch_arr_int.length;i++){
           String[] arrs = ch_arr_int[i].split(" ",2);
           if(i==0){
           arr_num_int[0] = arrs[1];
           arr_letters_int[0] = arrs[0];}
           else if(i==1){
           arr_num_int[1] = arrs[1];
           arr_letters_int[1] = arrs[1];}
        }
        int input_counter_print = 0;
        for(int i=0;i<arr_p.length;i++){
            input_counter_print += 1;
        }
        String[] ch_arr_int_print = new String[input_counter_print];
        int ch_count_int_print = 0;
        for(String a:arr_p){
            String sty_int_print = "";
            for(int i=0;i<a.length();i++){
                if (i!=0&&i!=1){
                char cntr_print = a.charAt(i);
                sty_int_print += cntr_print;
            }}
        sty_int_print = sty_int_print.trim();
        ch_arr_int_print[ch_count_int_print] = sty_int_print;
        ch_count_int_print += 1;
        }
        String[] cond_array = new String[ch_arr_int_print.length];
        String[] print_array = new String[ch_arr_int_print.length];
        int conditional_counter = 0;
        for(String a : ch_arr_int_print){
            if ( a.toLowerCase().indexOf("print".toLowerCase()) != -1 ){
                String[] arrs = a.split(" ",2);
                String[] arsss = arrs[1].split("print",2);
                print_array[conditional_counter] = arrs[0];
                cond_array[conditional_counter] = arsss[0];
                conditional_counter += 1;
            }
        }
        if(l_val != 0){
        int check_var_a_count = 0;
        int check_var_b_count = 0;
        int c = 0;
        int d = 0;
        try{
            for(int i=0;i<print_array.length;i++){
                if(print_array[i].toLowerCase().indexOf("print".toLowerCase()) != -1 ){
                   if(i==0){
                       System.out.println(cond_array[i].replaceAll("^\"|\"$", ""));
                   }
                   else if(i==1){
                       System.out.println(cond_array[i].replaceAll("^\"|\"$", ""));
                       int a = sc.nextInt();
                       c = a;
                       check_var_a_count += 1;
                   }
                   else if(i==2){
                       System.out.println(cond_array[i].replaceAll("^\"|\"$", ""));
                       int b = sc.nextInt();
                       d = b;
                       check_var_b_count += 1;
                   }
                }
            }
            if (check_var_a_count != 0 && check_var_b_count != 0){
                for(int i=0;i<print_array.length;i++){
                    if(print_array[i].toLowerCase().indexOf("if".toLowerCase()) != -1 ){
                       if(cond_array[i].toLowerCase().indexOf("<".toLowerCase()) != -1 ){
                           if (c<d){
                               System.out.println("a<b");
                           }
                       }
                    if(cond_array[i].toLowerCase().indexOf("=".toLowerCase()) != -1 ){
                           if (c==d){
                               System.out.println("a=b");
                           }
                       }
                    if(cond_array[i].toLowerCase().indexOf(">".toLowerCase()) != -1 ){
                           if (c>d){
                               System.out.println("a>b");
                           }
                       }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("One of the input is not provided for Comparision");
        }
        }}
        else if(k_val != 0 && f_val !=0 && g_val != 0){
            int prtn_counter = 0;
            for(String a : arr_p){
                if(a.toLowerCase().indexOf("print".toLowerCase()) != -1 ){
                    prtn_counter += 1;
                }
            }
        String[] prtn_array = new String[prtn_counter];
        String[] prtn_val = new String[prtn_counter];
        int prty_counter = 0;
        for(String a : arr_p){
            if(a.toLowerCase().indexOf("print".toLowerCase()) != -1 ){
                String[] arrs = a.split(" ",2);
                prtn_array[prty_counter] = arrs[1];
                prtn_val[prty_counter] = arrs[0];
                prty_counter += 1;
            }
        }
       int not_prt_counter = 0;
       int if_prt_counter = 0;
       for(String a : arrOfStr){
           if((a.toLowerCase().indexOf("print".toLowerCase()) == -1) && (a.toLowerCase().indexOf("if".toLowerCase()) == -1)){
              not_prt_counter += 1;
           }
           else if((a.toLowerCase().indexOf("print".toLowerCase()) == -1) && (a.toLowerCase().indexOf("if".toLowerCase()) != -1)){
               if_prt_counter += 1;
           }
       }
       String[] not_prt_array = new String[not_prt_counter];
       String[] not_prt_val = new String[not_prt_counter];
       String[] if_prt_array = new String[if_prt_counter];
       String[] if_prt_val = new String[if_prt_counter];
       int not_counter = 0;
       int if_counter = 0;
       for(String a : arrOfStr){
           if((a.toLowerCase().indexOf("print".toLowerCase()) == -1) && (a.toLowerCase().indexOf("if".toLowerCase()) == -1)){
              String[] arrp = a.split(" ",2);
              not_prt_array[not_counter] = arrp[1];
              not_prt_val[not_counter] = arrp[0];
              not_counter += 1;
           }
           else if((a.toLowerCase().indexOf("print".toLowerCase()) == -1) && (a.toLowerCase().indexOf("if".toLowerCase()) != -1)){
              String[] arrf = a.split(" ",2);
              if_prt_array[if_counter] = arrf[1];
              if_prt_val[if_counter] = arrf[0];
              if_counter += 1;
           }
       }
       int i_val = 0;
       for(String a : not_prt_array){
           if(a.toLowerCase().indexOf("integer".toLowerCase()) != -1 ){
               i_val += 1;
           }
       }
       if(i_val != 0){
           int print_counter = 0;
           for(String a : prtn_array){
               if(a.toLowerCase().indexOf("print".toLowerCase()) != -1 ){
                   print_counter += 1;
               }
           }
           String[] print_array = new String[print_counter];
           String[] print_val = new String[print_counter];
           int prtng_counter = 0;
           for(String a : prtn_array){
               if(a.toLowerCase().indexOf("print".toLowerCase()) != -1 ){
                   String[] arrk = a.split(" ",2);
                   print_array[prtng_counter] = arrk[1];
                   print_val[prtng_counter] = arrk[0];
                   prtng_counter += 1;
               }
           }
           for(int i=0;i<2;i++){
               System.out.println(print_array[i].replaceAll("^\"|\"$", ""));
           }
           try{
               int a,b;
               String line;
               String[] lineVector;
               line = sc.nextLine();
               lineVector = line.split(",");
               a=Integer.parseInt(lineVector[0]);
               b=Integer.parseInt(lineVector[1]);
               String[] f_array = new String[1];
               String[] f_eval = new String[1];
               for(String fu : if_prt_array){
                   if((fu.toLowerCase().indexOf("<".toLowerCase()) != -1) && (fu.toLowerCase().indexOf("goto".toLowerCase()) != -1)){
                       if(a<b){
                       String[] arrf = fu.split("goto",2);
                       String[] arr_f = arrf[1].split("goto",2);
                       for(int i=0;i<prtn_val.length;i++){
                           if(prtn_val[i].equals(arr_f[0].trim())){
                               String[] arr_pn = prtn_array[i].split("println",2);
                               System.out.println(arr_pn[1].trim().replaceAll("^\"|\"$", ""));
                           }
                       }
                   }
                        else{
                       for(int i = 0;i<print_array.length;i++){
                           if(i!=0&&i!=1){
                               System.out.println(print_array[i].replaceAll("^\"|\"$", ""));
                           }
                       }
                   }
                   }
               }
               
           }
           catch(Exception e){
               System.out.println("Only one input provided for comaprision");
           }
       }
    }}
        for(String a : end_array){
            if(a.toLowerCase().indexOf("END".toLowerCase()) != -1 ){
                System.exit(0);
            }
        }
    }
}