valgrind --tool=memcheck --leak-check=full  --show-leak-kinds=all  ./app  
valgrind --tool=massif ./app

