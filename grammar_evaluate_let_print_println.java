import java.util.Stack;
import java.io.*;
import java.util.*;
class EvaluateString
{
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

public static void main(String[] args)
{
   String str = """
   LET A = 4
   LET B = 5
   LET C = A*B+7
   PRINT A
   PRINT "*"
   PRINT B
   PRINT "+7="
   PRINTLN C
   """;
   int k = 0;
   String[] arrOfStr = str.split("\n");
   for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("LET".toLowerCase()) != -1 )
            {
                k += 1;
            }
        String arr[] = new String[k];
        int s = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("LET".toLowerCase()) != -1 )
            {
                arr[s] = a;
                s += 1;
            }
        int l = 0;
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("PRINT".toLowerCase()) != -1 )
            {
                l += 1;
            }
        int s_p = 0;
        String arr_p[] = new String[l];
        for (String a : arrOfStr)
            if ( a.toLowerCase().indexOf("PRINT".toLowerCase()) != -1 )
            {
                arr_p[s_p] = a;
                s_p += 1;
            }
        int counter = 0;
        for (String d : arr){
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
        for (String d : arr){
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
            }
            else if ( a.toLowerCase().indexOf("*".toLowerCase()) != -1){
                 val = a;
            }
            else if ( a.toLowerCase().indexOf("/".toLowerCase()) != -1){
                val = a;

            }
            else{
                   int prnt_counter = 0;
                   for(int i=0;i<arr_p.length;i++){
                   prnt_counter += 1;
                   }
                   int prnt_count = 0;
                   String arr_pntr[] = new String[prnt_counter];
                   for(int i=0;i<arr_p.length;i++){
                       String[] arrs_p = arr_p[i].split(" ",0);
                       arr_pntr[prnt_count] = arrs_p[1];
                       prnt_count += 1;
                   }
                   String delimeter = "/";
                   for(int i=0;i<arr_pntr.length;i++){
                       if( arr_pntr[i].toLowerCase().indexOf(delimeter.toLowerCase()) != -1 ){
                       String[] arrs_p = arr_pntr[i].split(delimeter,0);
                       for(int j=0;j<arr_letters.length;j++){
                           if(arrs_p[0].equals(arr_letters[j])){
                               String u_val = (arr_num[j]);
                               String final_str = u_val+delimeter+arrs_p[1];
                               System.out.println(EvaluateString.evaluate(final_str));
                           }
                           else{
                               String final_str = arrs_p[0] + delimeter + arrs_p[1];
                               System.out.println(EvaluateString.evaluate(final_str));
                           }
                       }
                   }
                   }

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
int prnt_count = 0;
String arr_pntr[] = new String[prnt_counter];
for(int i=0;i<arr_p.length;i++){
  String[] arrs_p = arr_p[i].split(" ",0);
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
        System.out.println(final_str_val);}
}
}

// Resources Used Google, Geeks for Geeks for Expression evaluation, Stackoverflow for errors and to check how to use some methods are used.
