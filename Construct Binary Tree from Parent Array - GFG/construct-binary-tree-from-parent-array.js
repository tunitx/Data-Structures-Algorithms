//{ Driver Code Starts
//Initial Template for javascript
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

function sort_and_print(v)
{
    v.sort(function (a, b) {
                    return a - b;
                });
    for(let i=0; i<v.length; i++){
        arr.push(v[i])
    }
}

function printLevelOrder(root)
{
    let v = [];
    let q = [];
    let start_q = 0;
    
    q.push(root);
    
    let next_row = null;
    
    while(q.length !== start_q)
    {
        let n = q[start_q];
        start_q++;
        
        if(n == next_row)
        {
            sort_and_print(v);
            v = [];
            next_row = null;
        }
        
        v.push(n.data);
        
        if(n.left)
        {
            q.push(n.left);
            if(next_row === null) next_row = n.left;
        }
        
        if(n.right)
        {
            q.push(n.right);
            if(next_row === null) next_row = n.right;
        }
    }
    sort_and_print(v);
    v = [];
}

let arr = [];

function main() {
    let t = parseInt(readLine());
    let i = 0;
    
    for(;i<t;i++)
    {
        let n = parseInt(readLine());
        let input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        let a = [];
        for(let i=0; i<n; i++){
            a.push(input_ar1[i]);
        }
        arr = [];
        let obj = new Solution();
        let res = obj.createTree(a, n); 
        printLevelOrder(res);
        let s = '';
        for(let i=0; i<arr.length; i++){
            s += arr[i] +" ";
        }
        console.log(s);
        
    }
    
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} parent
 * @param {number} n
 * @returns {Node}
*/

/*
class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution 
{
    //Function to construct binary tree from parent array.
    createTree(parent, n)
    {
        //your code here
        const map = new Map();
        for(let i =0; i<parent.length; i++){
            map.set(i, {
                node : new Node(i),
                count : 0
            });
        }
        let root = null;
        for(let i =0; i<parent.length ; i++){
            if(parent[i] ==-1){
                root = map.get(i).node;
            }
            else{
                let par = map.get(parent[i]).node;
                let child = map.get(i).node;
                if(map.get(parent[i]).count ==0){
                     par.left = child;
                   map.get(parent[i]).count++;
                }
                else{
                    par.right = child;
                }
            }
        }
        return root;
        
    }
}