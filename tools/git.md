# Branch

## Delete local branch
```
git branch -d <branch>
```

## Delete remote branch
```
git push origin --delete <branch>
```

## Fetch Updates from Remove
```
# The -p flag stands for prune which removes any remotetraccking references that no longer exist on the remote
git fetch -p
```

# Tag
```
# list tag
git tag -n

# show tag detail
git show <tag_name>

# add tag
git tag -a v1.4 -m "my version 1.4"

# add a tag to a commit
git tag -a v1.2 9fceb02 -m "Message here"

# push all tags
git push origin --tags

# push one tag
git push origin <tag_name>

# delete tag
git tag -d <tag_name>

# commit tag
git push --delete origin <tag_name>
```
