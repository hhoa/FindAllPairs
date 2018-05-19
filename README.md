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
First create a ```HashMap<Integer, Integer>``` to store value that will be explained below.

Then Loop through all elements in an array. For each element, called ```n```, I will check if ```X % n == 0```. I make this check because ```a * b = X``` can not have fixed number when make X divide either a or b.

Then if above condition met, I will check if X divide n has already existed as key in hashmap, I will call this condition is C2 for convention. If not exist, I will simply put ```<X / n, current index of n>``` to hashmap. Because if n is equal a in ```a * b = X``` then X / n equals b and store X divide n as key will make look up time much faster; and I also store current index because what we need is the index of the pair. What if C2 exist key, we just simply get the value of n that already stored in hashmap and the current index, that’s the pair of index we are looking for and you can store these values to whatever data structure you want.
