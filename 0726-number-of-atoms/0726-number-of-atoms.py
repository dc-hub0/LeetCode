from collections import defaultdict
import re

class Solution:
    def countOfAtoms(self, formula: str) -> str:
        def parse_formula(formula: str):
            # Regular expression to parse elements and counts
            token_pattern = r"([A-Z][a-z]*)(\d*)|(\()|(\))(\d*)"
            tokens = re.findall(token_pattern, formula)
            
            stack = [defaultdict(int)]
            for element, count, open_paren, close_paren, multiplier in tokens:
                if element:
                    count = int(count) if count else 1
                    stack[-1][element] += count
                elif open_paren:
                    stack.append(defaultdict(int))
                elif close_paren:
                    top = stack.pop()
                    multiplier = int(multiplier) if multiplier else 1
                    for key in top:
                        stack[-1][key] += top[key] * multiplier
            
            return stack[0]
        
        atom_counts = parse_formula(formula)
        sorted_atoms = sorted(atom_counts.keys())
        
        result = []
        for atom in sorted_atoms:
            result.append(atom)
            if atom_counts[atom] > 1:
                result.append(str(atom_counts[atom]))
        
        return ''.join(result)

# Example Usage
s = Solution()
print(s.countOfAtoms("H2O"))            # Output: "H2O"
print(s.countOfAtoms("Mg(OH)2"))        # Output: "H2MgO2"
print(s.countOfAtoms("K4(ON(SO3)2)2"))  # Output: "K4N2O14S4"
