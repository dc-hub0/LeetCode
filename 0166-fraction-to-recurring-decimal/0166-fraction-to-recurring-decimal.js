var fractionToDecimal = function(numerator, denominator) {
    if (denominator === 0) throw new Error("Denominator cannot be zero");

    if (numerator % denominator === 0) return (numerator / denominator).toString();

    let result = '';
    if (numerator < 0 ^ denominator < 0) result += '-';
    
    numerator = Math.abs(numerator);
    denominator = Math.abs(denominator);
    
    result += Math.floor(numerator / denominator);
    numerator %= denominator;
    
    if (numerator === 0) return result;
    
    result += '.';
    
    let map = new Map();
    map.set(numerator, result.length);
    
    while (numerator !== 0) {
        numerator *= 10;
        result += Math.floor(numerator / denominator);
        numerator %= denominator;
        
        if (map.has(numerator)) {
            let index = map.get(numerator);
            result = result.slice(0, index) + '(' + result.slice(index) + ')';
            return result;
        }
        
        map.set(numerator, result.length);
    }
    
    return result;
};

// Example usage:
console.log(fractionToDecimal(1, 2));    // Output: "0.5"
console.log(fractionToDecimal(2, 1));    // Output: "2"
console.log(fractionToDecimal(4, 333));  // Output: "0.(012)"
