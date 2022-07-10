# Check Process Tree
```pstree -p```

# Check all files including hidden files size
```du -sh .[^.]*```

# Stream Editor
sed -i "s/old_text/new_text/g" *.xml

# ps commnad
### view process runtime
ps -eo pid,etime,args | grep <process_name>

# grep command
## search file name in a jar file
grep -R filename file.jar

# find command
## find files including abc under the current directory 
find . -name *.xml -print | xargs grep abc
## get ht number of files under a directory
find . -type f | wc -l
## list matched files
find . -name -exec ls -l {} \;
## find those files modified within one day
find . -name *.java -mtime -1
## remove those file modified before 7 days
find . -mtime +7 -exec rm -f {} \;
## find files based on permission
find . -type f -perm -040

# alias command
## disable alias
/command

# lsof command
## show those files used by the pid process
lsof -g <pid>
## check the running app through port
lsof -i :<port>
  
# sort command
## comma separate = -t ,, 8th column = -k 8, discending = -r, 
sort -r -k 8 -t , source.txt > dest.txt
  

