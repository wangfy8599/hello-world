# Install lcov
```
sudo yum install lcov
```
# Configuration File
```
/etc/lcovrc
````

# goto project home
```
# 统计执行gcno，gcda文件，coverage.info
lcov -c -d . -o coverage.info --rc lcov_branch_coverage=1

# 将test.info中，包含的库文件删掉
lcov -r coverage.info "*/usr/*" -o coverage.info --rc lcov_branch_coverage=1

# 根据test.info，生成对应的覆盖率报告
genhtml --branch-coverage -o result coverage.info 

# Note：lcov在1.10版本后默认关闭分支覆盖率，想要打开，需要加上--rc lcov_branch_coverage=1和--branch-coverage，或者修改配置文件，统计分支覆盖率，对于一些判断语句比较复杂的语句，时间可能会比较慢。

```
