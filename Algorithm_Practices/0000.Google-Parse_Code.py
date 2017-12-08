"""
Repeat string between x[] x-times

test = "a3[b2[c1[d]]]e"
expected = "abcdcdbcdcdbcdcde"
"""
def parse(line):
  strBuffer = []
  i = 0
  rep = 0
  while (i < len(line)):
    if (line[i].isdigit()):
      if (rep != 0):
        rep = (rep * 10) + int(line[i])
      else:
        rep = int(line[i])
        
    elif (line[i] == "["):
      j = i + 1
      cnt = 0
      while (j < len(line)):
        if (line[j] == "["):
          cnt += 1
        elif (line[j] == "]" and cnt == 0):
          strBuffer.append(rep * parse(line[i + 1: j]))
          rep = 0
          i = j
        elif (line[j] == "]"):
          cnt -= 1
        j += 1
        
    else:
      strBuffer.append(line[i])
    i += 1
  
  return ''.join(strBuffer)
  
print(parse(test))
print(expected)
