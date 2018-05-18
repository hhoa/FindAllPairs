# FindAllPairs
Given an array of distinct signed integers and an integer X, find all pairs (a, b) in array so that a * b = X. All integers have 32 bit length.


## Run
You can clone project or download zip to run project.
Edit "question.txt" file like example below
```
1, -12, 98, 36, 67, -3, 17
36
```
With 
```
Line 1 is an distinct array of integer. 
Line 2 is X
```

Then run ```FindAllPairs.java``` file to see result like below
```
(0, 3)
(1, 5)
```

## Idea:
Read each element called ```n``` in given array. 
If ```x % n == 0``` - because ```a * b = X``` can not have float when modulus, we will store ```<(x / n) = z, (index of n)>``` to hashmap.

Because in the future when we read array, if we meet ```z``` again - we can know it by checking in hashmap, that number is what we are looking for; Remember that we store ```z``` in hashmap as key, not ```n```. Then we will take value of that number stored in hashmap and current index as index of pair number that multiply equal X.
