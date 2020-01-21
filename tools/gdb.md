# start gdb
gdb --args app arg1 arg2  
gdb app /tmp/core*dump  

# breakpoint
b x.cpp:23  
b x.cpp:22 if y == 3  
clear x.cpp:23  
del <start_breakpoint_num> - <end_breakpoint_num>  
catch throw  
## list breakpoints
info b  

# show code
list  
ctrl+x and ctrl+a  
info win  

# step int
s

# step over
n

# continue to run
c

# show thread stack trace
thread apply all bt  
bt

# show locals
info locals

# show variables
info variables

# show args
info args

# change frame
select-frame 5

# print variable
p <var>  
display <var>
