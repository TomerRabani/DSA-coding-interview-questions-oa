# Rotational Cipher
# One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
# For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
# Given a string and a rotation factor, return an encrypted string.
# Signature
# string rotationalCipher(string input, int rotationFactor)
# Input
# 1 <= |input| <= 1,000,000
# 0 <= rotationFactor <= 1,000,000
# Output
# Return the result of rotating input a number of times equal to rotationFactor.
# Example 1
# input = Zebra-493?
# rotationFactor = 3
# output = Cheud-726?
# Example 2
# input = abcdefghijklmNOPQRSTUVWXYZ0123456789
# rotationFactor = 39
# output = nopqrstuvwxyzABCDEFGHIJKLM9012345678



def rotationalCipher(input, rotation_factor):
  # Write your code here
  
  data = [0 for i in range(0, 128)]
  
  abCount = ord('z')-ord('a')+1
  capA = ord('A')
  a2a = ord('a')-ord('A')
 
  loopSize = 10
  result = list()
  for ch in list(input):
    startChar = None
    c = ord(ch)
    if data[c]!=0:
      result+=data[c]
      continue
    
    
    if ch>='0' and ch<='9':
      loopSize = 10
      startChar = ord('0')
    if c >= capA and c <= capA + abCount   \
    or c >= capA + a2a  and c <= capA + a2a + abCount:
      loopSize = abCount
      startChar = capA if c <= capA + abCount else capA+a2a
    
    if startChar != None:
      rotated = c + rotation_factor % loopSize
      rotated = rotated-loopSize if rotated >= startChar+loopSize else rotated
      result+=[chr(rotated)]
      data[c] = chr(rotated)
    else:
      result += [ch]
      data[c] = ch
  return ''.join(result)
