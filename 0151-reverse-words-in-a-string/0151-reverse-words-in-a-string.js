function reverseWords(s) {
    // Step 1: Split the string by spaces
    let words = s.split(' ');

    // Step 2: Filter out any empty strings (caused by multiple spaces)
    words = words.filter(word => word.length > 0);

    // Step 3: Reverse the array of words
    words.reverse();

    // Step 4: Join the reversed array into a single string with spaces in between
    return words.join(' ');
}

// Test cases
console.log(reverseWords("the sky is blue")); // Output: "blue is sky the"
console.log(reverseWords("  hello world  ")); // Output: "world hello"
console.log(reverseWords("a good   example")); // Output: "example good a"
