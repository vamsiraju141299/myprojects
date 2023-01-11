from __future__ import print_function

class BrainFuck:
    def brainfuck(self,input_val, start_index, end_index, data_string, data_index):
       
        if len(input_val) == 0: return
   
        if start_index < 0:
            start_index = 0
           
        if start_index >= len(input_val):
            start_index = len(input_val) - 1
           
        if end_index < 0:
            end_index = 0
           
        if end_index >= len(input_val):
            end_index = len(input_val) - 1
       
        data_list = [0] * 30000
        index_pointer = 0
        i_val = start_index
        while i_val <= end_index:
            string_val = input_val[i_val]
           
            # '>'  this will move our pointer to right
            if string_val == '>':
                index_pointer += 1
                # when the pointer goes to the last index the pointer will be assigned to index 0
                if index_pointer >= len(data_list):
                    index_pointer = 0
                   
            # < when the pointer goes to the last index the pointer will be assigned to 0
            elif string_val == '<':
                index_pointer -= 1
                # if pointer is at < 0 then the pointer will be assigned to last index
                if index_pointer < 0:
                    index_pointer = len(index_pointer) - 1
                   
            # + increments the value that is there in the byte index by 1
            elif string_val == '+':
                data_list[index_pointer] += 1
               
            # - decrements the value that is there in the byte index by 1
            elif string_val == '-':
                data_list[index_pointer] -= 1
               
            # . outputs the character
            elif string_val == '.':
                print(chr(data_list[index_pointer]), end="")
               
            # , inputs a character and store it in the cell at the pointer
            elif string_val == ',':
                if data_index >= 0 and data_index < len(data_string):
                    data_list[index_pointer] = ord(data_string[index_pointer])
                    index_pointer += 1
                else:
                    data_list[index_pointer] = 0 # out of input
                   
            # checks for the matching and will iterate until the current value becomes 0
            elif string_val =='[':
                if data_list[index_pointer] == 0:
                    loop_val = 1
                    while loop_val > 0:
                        i_val += 1
                        c = input_val[i_val]
                        if c == '[':
                            loop_val += 1
                        elif c == ']':
                            loop_val -= 1
           
            # checks for the matching and will iterate until the current value becomes 0
            elif string_val == ']':
                loop_val = 1
                while loop_val > 0:
                    i_val -= 1
                    c = input_val[i_val]
                    if c == '[':
                        loop_val -= 1
                    elif c == ']':
                        loop_val += 1
                i_val -= 1
            i_val += 1

if __name__ == "__main__":
    input_val = input()
    brainfk = BrainFuck()
    brainfk.brainfuck(input_val, 0, len(input_val) - 1, "", 0)