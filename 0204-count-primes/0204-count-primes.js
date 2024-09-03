function countPrimes(n) {
    if (n <= 2) return 0;

    const isPrime = Array(n).fill(true);
    isPrime[0] = isPrime[1] = false;

    for (let i = 2; i * i < n; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
    }

    return isPrime.filter(Boolean).length;
}
 
console.log(countPrimes(10));  
console.log(countPrimes(0));  
console.log(countPrimes(1));  
