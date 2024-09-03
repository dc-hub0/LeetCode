function isIsomorphic(s, t) {
    if (s.length !== t.length) return false;

    const mapST = {};
    const mapTS = {};

    for (let i = 0; i < s.length; i++) {
        const charS = s[i];
        const charT = t[i];

        if ((mapST[charS] && mapST[charS] !== charT) || (mapTS[charT] && mapTS[charT] !== charS)) {
            return false;
        }

        mapST[charS] = charT;
        mapTS[charT] = charS;
    }

    return true;
}
 
console.log(isIsomorphic("egg", "add"));   
console.log(isIsomorphic("foo", "bar"));   
console.log(isIsomorphic("paper", "title")); 
