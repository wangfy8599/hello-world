# start gdb
gdb --args app arg1 arg2
gdb app /tmp/core*dump

# set breakpoint
b x.cpp:23

# remove breakpoint
clear x.cpp:23

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
