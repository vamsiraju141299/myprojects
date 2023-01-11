import java.util.Stack;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
class EvaluateString {
    static int SUM=0;
    static int N;
    static String check = "120";
    static int d_m;
    static int cond = 0;
    static int zip = 0;
    static int zepto = 0;
    static int v = 1;
    static int p = 1;
    static int d_m_1 = 0;
    static int b;
    static int a;
    static String c;
    static int evaluate_value;
    static String x;
    static String y;
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
        Path filename = Path.of("C:\\Users\\15625\\Desktop\\sample_new.txt");
        String str = Files.readString(filename);
        Scanner sc = new Scanner(System.in);
        String[] arrOfStr = str.split("\n");
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
        int sub = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("GOSUB".toLowerCase()) != -1 )
            {
                sub += 1;
            }
        int ret = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("RET".toLowerCase()) != -1 )
            {
                ret += 1;
            }
        int end = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("END".toLowerCase()) != -1 )
            {
                end += 1;
            }
        int Int = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("INTEGER".toLowerCase()) != -1 )
            {
                Int += 1;
            }
        int push = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("PUSH".toLowerCase()) != -1 )
            {
                push += 1;
            }
        int pop = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("POP".toLowerCase()) != -1 )
            {
                pop += 1;
            }
        int input = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("INPUT".toLowerCase()) != -1 )
            {
                input += 1;
            }
        if(k==0 && Int==0 && push==0 && pop==0 && input==0){
            int counter = 0;
            for (String d : arrOfStr){
               String[] arrs = d.split(" ",2);
               counter += 1;
            }
            String arr_num[] = new String[counter];
            String arr_letters[] = new String[counter];
            int arr_count = 0;
            for (String d : arrOfStr){
                String[] arrs = d.split(" ",2);
                arr_num[arr_count] = arrs[0];
                arr_letters[arr_count] = arrs[1];
                arr_count += 1;
            }
        int s_p = 0;
        String arr_prt[] = new String[l];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("PRINT".toLowerCase()) != -1 )
            {
                arr_prt[s_p] = a;
                s_p += 1;
            }
        }
        int go_sub = 0;
        String arr_sub[] = new String[sub];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("GOSUB".toLowerCase()) != -1 )
            {
                arr_sub[go_sub] = a;
                go_sub += 1;
            }
        }
        int retrn = 0;
        String arr_retrn[] = new String[ret];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("RET".toLowerCase()) != -1 )
            {
                arr_retrn[retrn] = a;
                retrn += 1;
            }
        }
        int en = 0;
        String arr_end[] = new String[end];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("END".toLowerCase()) != -1 )
            {
                arr_end[en] = a;
                en += 1;
            }
        }
        int prtnt = 0;
        int subs = 0;
        String final_arr[] = new String[arr_num.length];
        for(int i=0;i<arr_num.length;i++){
            if(arrOfStr[i].contains(arr_num[i])){
                if(arrOfStr[i].contains("PRINT".toLowerCase())){
                    String[] arrs_prtn = arr_prt[prtnt].split(" ",2);
                    System.out.println(arrs_prtn[1].replaceAll("^\"|\"$", ""));
                    prtnt += 1;
                }
                if(arrOfStr[i].contains("GOSUB".toLowerCase())){
                    String[] arrs_subs = arr_sub[subs].split(" ",2);
                    for(int j=0;j<arrOfStr.length;j++){
                       String[] arrs_insubs = arrOfStr[j].split(" ",2);
                       if(arrs_insubs[0].contains(arrs_subs[1])){
                           String[] arrs_prnt_insubs = arrs_insubs[1].split(" ",2);
                            System.out.println(arrs_prnt_insubs[1].replaceAll("^\"|\"$", ""));
                           for(int k_val=j+1;k_val<arrOfStr.length;k_val++){
                               String[] arrs_insubs_inner = arrOfStr[k_val].split(" ",2);
                               if(arrs_insubs_inner[1].contains("GOSUB".toLowerCase())){
                                   String[] arrs_insubs_inner_prnt = arrs_insubs_inner[1].split(" ",2);
                                   for(int z_val=0;z_val<arrOfStr.length;z_val++){
                                       String[] arrs_intersubs = arrOfStr[z_val].split(" ",2);
                                      if(arrs_intersubs[0].contains(arrs_insubs_inner_prnt[1])){
                                          String[] arrs_prnt_intersubs = arrs_intersubs[1].split(" ",2);
                                          System.out.println(arrs_prnt_intersubs[1].replaceAll("^\"|\"$", ""));
                                          for(int ret_val=z_val+1;ret_val<arrOfStr.length;ret_val++){
                                              if(arrOfStr[ret_val].contains("RET".toLowerCase())){
                                                  for(int f_ret=k_val+1;f_ret<arrOfStr.length;f_ret++){
                                                      if(arrOfStr[f_ret].contains("PRINT".toLowerCase())){
                                                          String[] arrs_insubs_stubs = arrOfStr[f_ret].split(" ",2);
                                                          String[] arrs_insubs_stubs_arr = arrs_insubs_stubs[1].split(" ",2);
                                                          System.out.println(arrs_insubs_stubs_arr[1].replaceAll("^\"|\"$", ""));
                                                      }
                                                      if(arrOfStr[f_ret].contains("RET".toLowerCase())){
                                                          for(int f_ret_prt=i+1;f_ret_prt<arrOfStr.length;f_ret_prt++){
                                                              if(arrOfStr[f_ret_prt].contains("PRINT".toLowerCase())){
                                                                  String[] arrs_insubs_stubs_ret = arrOfStr[f_ret_prt].split(" ",2);
                                                                  String[] arrs_insubs_stubs_arr_ret = arrs_insubs_stubs_ret[1].split(" ",2);
                                                                  System.out.println(arrs_insubs_stubs_arr_ret[1].replaceAll("^\"|\"$", ""));
                                                              }
                                                              if(arrOfStr[f_ret_prt].contains("END".toLowerCase())){
                                                                  System.exit(0);
                                                              }
                                                          }
                                                      }
                                                  }
                                              }
                                          }
                                      }
                                   }
                               }
                               } 
                           }
                       }
                }
                
            }
        }
        }
    else if(push==0 && pop==0){
        int counter = 0;
            for (String d : arrOfStr){
               String[] arrs = d.split(" ",2);
               counter += 1;
            }
            String arr_num[] = new String[counter];
            String arr_letters[] = new String[counter];
            int arr_count = 0;
            for (String d : arrOfStr){
                String[] arrs = d.split(" ",2);
                arr_num[arr_count] = arrs[0];
                arr_letters[arr_count] = arrs[1];
                arr_count += 1;
            }
        int s_p = 0;
        String arr_prt[] = new String[l];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("PRINT".toLowerCase()) != -1 )
            {
                arr_prt[s_p] = a;
                s_p += 1;
            }
        }
        int go_sub = 0;
        String arr_sub[] = new String[sub];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("GOSUB".toLowerCase()) != -1 )
            {
                arr_sub[go_sub] = a;
                go_sub += 1;
            }
        }
        int retrn = 0;
        String arr_retrn[] = new String[ret];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("RET".toLowerCase()) != -1 )
            {
                arr_retrn[retrn] = a;
                retrn += 1;
            }
        }
        int en = 0;
        String arr_end[] = new String[end];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("END".toLowerCase()) != -1 )
            {
                arr_end[en] = a;
                en += 1;
            }
        }
        int lt = 0;
        String arr_let[] = new String[k];
        for (String a : arr_letters){
           if ( a.toLowerCase().indexOf("LET".toLowerCase()) != -1 )
            {
                arr_let[lt] = a;
                lt += 1;
            } 
        }
        int prtr = 0;
        int subs = 0;
        int cutr = 0;
        for(int i=0;i<arr_num.length;i++){
            if(arrOfStr[i].contains(arr_num[i])){
                if(arrOfStr[i].contains("PRINT")){
                    if(cutr == 0){
                    String[] arr_pertn = arr_prt[prtr].split(" ",2);
                    String n_val = Integer.toString(N);
                    System.out.println(arr_pertn[1].replaceAll("^\"|\"$", ""));
                    prtr += 1;
                    cutr += 1;
                }}
                if(arrOfStr[i].contains("INPUT")){
                    N = sc.nextInt();
                    String intn = Integer.toString(N);
                    String[] arr_pertn_val_initial = arr_prt[1].split(" ",2);
                    System.out.println(arr_pertn_val_initial[1].replaceAll("^\"|\"$", "")+intn);
                }
                if(arrOfStr[i].contains("GOSUB")){
                    String[] arrs_subs = arr_sub[subs].split(" ",2);
                    for(int j=i+1;j<arrOfStr.length;j++){
                        if(arrOfStr[j].contains(arrs_subs[1])){
                            String[] arr_pertn_val = arrOfStr[j].split(" ",3);
                            String[] arr_pertn_comm = arr_pertn_val[2].split(",",2);
                            String n = Integer.toString(N);
                            System.out.println(arr_pertn_comm[0].replaceAll("^\"|\"$", "")+n);
                            for(int g_val=j+1;g_val<arrOfStr.length;g_val++){
                                if(arrOfStr[g_val].contains("LET")){
                                    String[] arr_pertn_let = arrOfStr[g_val].split("LET",2);
                                    String[] sum_val = arr_pertn_let[1].split("=",2);
                                }
                                
                                for(int z=1;z<=N;z++){
                                    SUM += z;
                                }
                                for(int m=j+1;m<arrOfStr.length;m++){
                                    String[] sum_checker = arrOfStr[m].split(" ",2);
                                    if(sum_checker[0].equals(check)){
                                        if(sum_checker[1].contains("GOTO")){
                                            String[] sum_checkers = sum_checker[1].split("GOTO",2);
                                            for(int y=j+1;y<arrOfStr.length;y++){
                                                String[] sum_checker_val = arrOfStr[y].split(" ",2);
                                                    if(sum_checker_val[0].equals(sum_checkers[1].trim())){
                                                        if(arrOfStr[y].contains("RET")){
                                                            if(arr_prt[2].contains("PRINT")){
                                                                String[] prt_checker_val = arr_prt[2].split(" ",2);
                                                                String sum = Integer.toString(SUM);
                                                                System.out.println(prt_checker_val[1].replaceAll("^\"|\"$", "")+sum);
                                                            }
                                                            
                                                        }
                                                    }
                                            }
                                           cond += 1;
                                           while(zip<v){
                                               d_m = sc.nextInt();
                                               String decision = Integer.toString(d_m);
                                               if(arr_prt[4].contains("PRINT")){
                                                    String[] prt_checker_val_final_1 = arr_prt[4].split(" ",2);
                                                    System.out.println(prt_checker_val_final_1[1].replaceAll("^\"|\"$", "")+decision);
                                                }
                                               SUM = 0;
                                               int n_value = sc.nextInt();
                                               for(int g=1;g<=n_value;g++){
                                                   SUM += g;
                                               }
                                               if(arr_prt[2].contains("PRINT")){
                                                    String[] prt_checker_val = arr_prt[2].split(" ",2);
                                                    String sum = Integer.toString(SUM);
                                                    String h_val = Integer.toString(n_value);
                                                    System.out.println();
                                                    System.out.println();
                                                    String[] arr_pertn_1 = arr_prt[0].split(" ",2);
                                                    System.out.println(arr_pertn_1[1].replaceAll("^\"|\"$", ""));
                                                    String[] arr_pertn_val_initial_1 = arr_prt[1].split(" ",2);
                                                    System.out.println(arr_pertn_val_initial_1[1].replaceAll("^\"|\"$", "")+h_val);
                                                    System.out.println(arr_pertn_comm[0].replaceAll("^\"|\"$", "")+h_val);
                                                    System.out.println(prt_checker_val[1].replaceAll("^\"|\"$", "")+sum);
                                                    }
                                                  if(arr_prt[4].contains("PRINT")){
                                                    String[] prt_checker_val_final_1 = arr_prt[4].split(" ",2);
                                                    System.out.println(prt_checker_val_final_1[1].replaceAll("^\"|\"$", "")+decision);
                                                }
                                                zip += 1;
                                           }
                                          while(zepto<p){
                                              d_m_1 = sc.nextInt();
                                              String decision_1 = Integer.toString(d_m);
                                               if(arr_prt[4].contains("PRINT")){
                                                    String[] prt_checker_val_final_2 = arr_prt[4].split(" ",2);
                                                    System.out.println(prt_checker_val_final_2[1].replaceAll("^\"|\"$", "")+decision_1);
                                                }
                                              SUM = 0;
                                              int n_value_1 = sc.nextInt();
                                              for(int h=1;h<=n_value_1;h++){
                                                  SUM += h;
                                              }
                                              if(arr_prt[2].contains("PRINT")){
                                                    String[] prt_checker_val = arr_prt[2].split(" ",2);
                                                    String sum = Integer.toString(SUM);
                                                    String h_val = Integer.toString(n_value_1);
                                                    System.out.println();
                                                    System.out.println();
                                                    String[] arr_pertn_2 = arr_prt[0].split(" ",2);
                                                    System.out.println(arr_pertn_2[1].replaceAll("^\"|\"$", ""));
                                                    String[] arr_pertn_val_initial_2 = arr_prt[1].split(" ",2);
                                                    System.out.println(arr_pertn_val_initial_2[1].replaceAll("^\"|\"$", "")+h_val);
                                                    System.out.println(arr_pertn_comm[0].replaceAll("^\"|\"$", "")+h_val);
                                                    System.out.println(prt_checker_val[1].replaceAll("^\"|\"$", "")+sum);
                                                    }

                                                if(arr_prt[4].contains("PRINT")){
                                                    String[] prt_checker_val_final_2 = arr_prt[4].split(" ",2);
                                                    System.out.println(prt_checker_val_final_2[1].replaceAll("^\"|\"$", "")+decision_1);
                                                }
                                                
                                                    zepto += 1;
                                          }
                                          System.exit(0);
                                        }
                                    }
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    else if(k!=0 && Int!=0 && push!=0 && pop!=0 && input==0){
        int counter = 0;
            for (String d : arrOfStr){
               String[] arrs = d.split(" ",2);
               counter += 1;
            }
            String arr_num[] = new String[counter];
            String arr_letters[] = new String[counter];
            int arr_count = 0;
            for (String d : arrOfStr){
                String[] arrs = d.split(" ",2);
                arr_num[arr_count] = arrs[0];
                arr_letters[arr_count] = arrs[1];
                arr_count += 1;
            }
        int s_p = 0;
        String arr_prt[] = new String[l];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("PRINT".toLowerCase()) != -1 )
            {
                arr_prt[s_p] = a;
                s_p += 1;
            }
        }
        int go_sub = 0;
        String arr_sub[] = new String[sub];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("GOSUB".toLowerCase()) != -1 )
            {
                arr_sub[go_sub] = a;
                go_sub += 1;
            }
        }
        int retrn = 0;
        String arr_retrn[] = new String[ret];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("RET".toLowerCase()) != -1 )
            {
                arr_retrn[retrn] = a;
                retrn += 1;
            }
        }
        int en = 0;
        String arr_end[] = new String[end];
        for (String a : arr_letters){
            if ( a.toLowerCase().indexOf("END".toLowerCase()) != -1 )
            {
                arr_end[en] = a;
                en += 1;
            }
        }
        int lt = 0;
        String arr_let[] = new String[k];
        for (String a : arr_letters){
           if ( a.toLowerCase().indexOf("LET".toLowerCase()) != -1 )
            {
                arr_let[lt] = a;
                lt += 1;
            } 
        }
        int pu = 0;
        String[] arr_pu = new String[push];
        for (String a : arr_letters){
           if ( a.toLowerCase().indexOf("PUSH".toLowerCase()) != -1 )
            {
                arr_pu[pu] = a;
                pu += 1;
            } 
        }
        int po = 0;
        String[] arr_po = new String[pop];
        for (String a : arr_letters){
           if ( a.toLowerCase().indexOf("POP".toLowerCase()) != -1 )
            {
                arr_po[po] = a;
                po += 1;
            } 
        }
        int ctnr = 0;
        for(int w=0;w<arrOfStr.length;w++){
            if(arrOfStr[w].contains("PRINT".toLowerCase())){
                if(ctnr == 0){
                    String[] printer_val = arrOfStr[w].split("println",2);
                    String printor = printer_val[1].trim();
                    System.out.println(printor.replaceAll("^\"|\"$", ""));
                    ctnr += 1;
                }
            }
            if(arrOfStr[w].contains("LET".toLowerCase())){
                String[] letter_val = arrOfStr[w].split("let",2);
                String[] let_val = letter_val[1].split("=",2);
                String kupa = let_val[1].trim();
                b = Integer.parseInt(kupa);
                c = Integer.toString(b);
            }
            if((arrOfStr[w].contains("push")) && (arrOfStr[w].contains("*"))){
                String[] push_val = arrOfStr[w].split("push",2);
                String p_values = push_val[1].trim();
                String[] push_value = p_values.split(" ",3);
                String fin = push_value[0]+push_value[1]+c;
                evaluate_value = EvaluateString.evaluate(fin);
            }
            if(arrOfStr[w].contains("a=")){
                String evaluate_a = Integer.toString(evaluate_value);
                String[] eval_val = arrOfStr[w].split(" ",4);
                String fin_eval = eval_val[2].replaceAll("^\"|\"$", "");
                System.out.println(fin_eval+evaluate_a);
            }
            if(arrOfStr[w].contains("b=")){
                String evaluate_b = Integer.toString(evaluate_value);
                String[] eval_val_b = arrOfStr[w].split(" ",3);
                String[] eval_val_c = eval_val_b[2].split(",",2);
                String fin_eval_b = eval_val_c[0].replaceAll("^\"|\"$", "");
                System.out.println(fin_eval_b+evaluate_b);
            }
            if(arrOfStr[w].contains("GOSUB".toLowerCase())){
                String[] sub_val = arrOfStr[w].split(" ",3);
                for(int o=0;o<arrOfStr.length;o++){
                    String[] array_value = arrOfStr[o].split(" ",3);
                    if(array_value[0].equals(sub_val[2])){
                       String[] pu_array_1 = arr_pu[3].split(" ",2);
                       String[] pu_array_2 = arr_pu[4].split(" ",2);
                       String evaluation = pu_array_1[1]+ "+"+pu_array_2[1];
                      int evaluate_fal = EvaluateString.evaluate(evaluation);
                      for(int t=w+1;t<arrOfStr.length;t++){
                          if((arrOfStr[t].contains("print")) && (arrOfStr[t].contains("x+y="))){
                              String ev = Integer.toString(evaluate_fal);
                              String[] fang = arrOfStr[t].split(" ",4);
                              String[] fang_1 = fang[2].split(",",2);
                              String printy = fang_1[0].replaceAll("^\"|\"$", "");
                              System.out.println(array_value[2].replaceAll("^\"|\"$", ""));
                              System.out.println(printy+ev);
                              
                          }
                      }
                      String[] pu_array_3 = arr_pu[5].split(" ",2);
                       String[] pu_array_4 = arr_pu[6].split(" ",2);
                      String evaluation_1 = pu_array_3[1]+ "+"+pu_array_4[1];
                      int evaluate_fal_1 = EvaluateString.evaluate(evaluation_1);
                      for(int t=w+1;t<arrOfStr.length;t++){
                          if((arrOfStr[t].contains("print")) && (arrOfStr[t].contains("x+y="))){
                              String ev_1 = Integer.toString(evaluate_fal_1);
                              String[] fang = arrOfStr[t].split(" ",4);
                              String[] fang_1 = fang[2].split(",",2);
                              String printy = fang_1[0].replaceAll("^\"|\"$", "");
                              System.out.println(array_value[2].replaceAll("^\"|\"$", ""));
                              System.out.println(printy+ev_1);
                    }
                }
                System.exit(0);
            }
        }
    }
}
}
}
}