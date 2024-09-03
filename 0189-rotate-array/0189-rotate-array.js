function rotate(nums, k) {
    k = k % nums.length;
    nums.unshift(...nums.splice(nums.length - k, k));
}

const nums1 = [1, 2, 3, 4, 5, 6, 7];
rotate(nums1, 3);
console.log(nums1);  
const nums2 = [-1, -100, 3, 99];
rotate(nums2, 2);
console.log(nums2);  