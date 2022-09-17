origin, to_remove,*a = open(0, 'rb').read().split(b'\n')
L = len(to_remove)

s = bytearray()
for c in origin:
    s.append(c)
    if to_remove[-1] == c:
        if to_remove == s[-L:]:
            del s[-L:]
print(s.decode() if s else 'FRULA')