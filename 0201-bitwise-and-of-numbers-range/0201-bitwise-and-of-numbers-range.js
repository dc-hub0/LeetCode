function rangeBitwiseAnd(left, right) {
    while (right > left) {
        right &= (right - 1);
    }
    return left & right;
}

 
console.log(rangeBitwiseAnd(5, 7)); 
console.log(rangeBitwiseAnd(0, 0));  
console.log(rangeBitwiseAnd(1, 2147483647));  
