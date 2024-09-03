function isHappy(n) {
    function getNext(num) {
        let totalSum = 0;
        while (num > 0) {
            const digit = num % 10;
            totalSum += digit * digit;
            num = Math.floor(num / 10);
        }
        return totalSum;
    }

    let slow = n;
    let fast = getNext(n);

    while (fast !== 1 && slow !== fast) {
        slow = getNext(slow);
        fast = getNext(getNext(fast));
    }

    return fast === 1;
}

 
console.log(isHappy(19));  
console.log(isHappy(2));   
