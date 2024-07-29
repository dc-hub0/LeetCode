/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    let left = 0;
    let right = numbers.length - 1;
    
    while (left < right) {
        let sum = numbers[left] + numbers[right];
        
        if (sum === target) {
            return [left + 1, right + 1]; // Convert 0-based index to 1-based index
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    
    return []; // Return an empty array if no solution is found
};

// Example usage:
console.log(twoSum([2, 7, 11, 15], 9)); // Output: [1, 2]
console.log(twoSum([1, 2, 3, 4, 5], 8)); // Output: [3, 5]
