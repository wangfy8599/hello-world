./configure --enable-prof

make

jeprof --show_bytes --gif /usr/bin/java jeprof*.heap > ./app-profiling.gif

jeprof --show_bytes --pdf /usr/bin/java jeprof*.heap > ./test.pdf

jeprof --show_bytes /usr/bin/java jeprof*.heap

top, disasm
