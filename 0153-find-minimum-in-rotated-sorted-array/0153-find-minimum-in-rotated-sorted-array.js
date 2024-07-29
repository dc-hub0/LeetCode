function findMin(nums) {
    let left = 0;
    let right = nums.length - 1;

    if (nums[left] < nums[right]) {
        return nums[left];
    }

    while (left < right) {
        let mid = Math.floor((left + right) / 2);

        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }
 
        if (nums[mid - 1] > nums[mid]) {
            return nums[mid];
        }

        if (nums[mid] > nums[left]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return nums[left];
}

console.log(findMin([3, 4, 5, 1, 2])); 
console.log(findMin([4, 5, 6, 7, 0, 1, 2]));
console.log(findMin([11, 13, 15, 17])); 
