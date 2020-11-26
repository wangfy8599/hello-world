# start gdb
```
gdb --args app arg1 arg2  
gdb app /tmp/core*dump
gdb attach <pid>
```  

# breakpoint
```
b x.cpp:23  
b x.cpp:22 if y == 3  
clear x.cpp:23  
del <start_breakpoint_num> - <end_breakpoint_num>  
catch throw  
-- list breakpoints
info b
-- delete all breakpoints
del

catch throw  
catch catch  
catch fork  
catch load  
catch syscall exit exit_group  
```

# show code
```
list  
ctrl+x and ctrl+a  
info win  
```

# flow control
```
# start run
r

# step int
s

# step over
n

# continue to run
c
```

# show runtime information
```
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
```

# Run more commands in one line  
```
define fn
> command1
> command2
> command3
> end

# Then type
fn
