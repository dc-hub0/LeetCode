function hammingWeight(n) {
    let count = 0;
    while (n !== 0) {
        count += n & 1;
        n >>>= 1;
    }
    return count;
}

console.log(hammingWeight(11));  
console.log(hammingWeight(128));  
console.log(hammingWeight(2147483645));  
