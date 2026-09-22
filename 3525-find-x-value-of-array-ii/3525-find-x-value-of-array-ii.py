from array import array


class Solution:
    def resultArray(self, nums, k, queries):

        n = len(nums)

        # Iterative segment tree size
        size = 1
        while size < n:
            size <<= 1

        # product[node] = product of entire segment % k
        product = array('b', [1]) * (2 * size)

        # prefix[r][node] = number of prefixes with remainder r
        prefix = [
            array('i', [0]) * (2 * size)
            for _ in range(k)
        ]

        # -----------------------------------
        # Create leaf
        # -----------------------------------

        for i in range(n):
            node = size + i
            r = nums[i] % k

            product[node] = r
            prefix[r][node] = 1

        # Empty leaves
        # Their product is 1, and they have no prefixes.
        for i in range(size - 1, 0, -1):

            left = i << 1
            right = left | 1

            product[i] = (product[left] * product[right]) % k

            lp = product[left]

            for r in range(k):
                prefix[r][i] = prefix[r][left]

            for r in range(k):
                cnt = prefix[r][right]

                if cnt:
                    new_r = (lp * r) % k
                    prefix[new_r][i] += cnt

        # -----------------------------------
        # Update one position
        # -----------------------------------

        def update(index, value):

            node = size + index
            r = value % k

            product[node] = r

            for j in range(k):
                prefix[j][node] = 0

            prefix[r][node] = 1

            node >>= 1

            while node:

                left = node << 1
                right = left | 1

                lp = product[left]

                product[node] = (
                    lp * product[right]
                ) % k

                for j in range(k):
                    prefix[j][node] = prefix[j][left]

                for j in range(k):
                    cnt = prefix[j][right]

                    if cnt:
                        new_r = (lp * j) % k
                        prefix[new_r][node] += cnt

                node >>= 1

        # -----------------------------------
        # Merge two pieces
        #
        # left + right
        # -----------------------------------

        def merge(left_product, left_prefix,
                  right_product, right_prefix):

            new_product = (
                left_product * right_product
            ) % k

            new_prefix = [0] * k

            # Prefix lies completely in left
            for r in range(k):
                new_prefix[r] = left_prefix[r]

            # Prefix = entire left + prefix of right
            for r in range(k):
                cnt = right_prefix[r]

                if cnt:
                    new_r = (left_product * r) % k
                    new_prefix[new_r] += cnt

            return new_product, new_prefix

        # -----------------------------------
        # Range query [ql, qr]
        # -----------------------------------

        def query(ql, qr):

            ql += size
            qr += size + 1

            # Result accumulated from left side
            left_product = 1
            left_prefix = [0] * k

            # Result accumulated from right side
            right_product = 1
            right_prefix = [0] * k

            while ql < qr:

                if ql & 1:

                    # Merge current left result + ql
                    node = ql

                    old_product = left_product

                    new_prefix = [0] * k

                    for r in range(k):
                        new_prefix[r] = left_prefix[r]

                    for r in range(k):
                        cnt = prefix[r][node]

                        if cnt:
                            new_r = (old_product * r) % k
                            new_prefix[new_r] += cnt

                    left_prefix = new_prefix
                    left_product = (
                        old_product * product[node]
                    ) % k

                    ql += 1

                if qr & 1:

                    qr -= 1
                    node = qr

                    # Merge node + current right result
                    node_product = product[node]

                    new_prefix = [0] * k

                    for r in range(k):
                        new_prefix[r] = prefix[r][node]

                    for r in range(k):
                        cnt = right_prefix[r]

                        if cnt:
                            new_r = (node_product * r) % k
                            new_prefix[new_r] += cnt

                    right_prefix = new_prefix
                    right_product = (
                        node_product * right_product
                    ) % k

                ql >>= 1
                qr >>= 1

            # Combine left and right
            final_product, final_prefix = merge(
                left_product,
                left_prefix,
                right_product,
                right_prefix
            )

            return final_prefix

        # -----------------------------------
        # Process queries
        # -----------------------------------

        answer = []

        for index, value, start, x in queries:

            update(index, value)

            result = query(start, n - 1)

            answer.append(result[x])

        return answer