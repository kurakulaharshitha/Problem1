class Solution(object):
    def maxNumberOfBalloons(self, text):
        text_count = {}
        for ch in text:
            text_count[ch] = text_count.get(ch, 0) + 1
        need = {
            'b': 1,
            'a': 1,
            'l': 2,
            'o': 2,
            'n': 1
        }
        answer = float('inf')
        for ch in need:
            available = text_count.get(ch, 0)
            required = need[ch]
            possible = available // required
            answer = min(answer, possible)
        return answer