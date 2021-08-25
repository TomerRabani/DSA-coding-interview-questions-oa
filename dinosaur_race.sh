#https://leetcode.com/discuss/interview-question/391865/Facebook-Software-Engineer-Phone-Screen-Interview-Questions-or-REJECT

#! /bin/bash
#Given the following formula,
#speed = ((STRIDE_LENGTH / LEG_LENGTH) - 1) * SQRT(LEG_LENGTH * g)
#Where g = 9.8 m/s^2 (gravitational constant)` Write a program to read in the data files from disk,
#it must then print the names of only the
#bipedal dinosaurs from fastest to slowest. Do not print any other information.
#


awk -F, '
FNR>1 && FNR==NR{
	a[$1]=$2+0.0
	# print(a[$1])
	next
}
FNR>1 && FNR!=NR && $3=="bipedal" {
	# print("bi")
	leg_len = a[$1]+0.0
	# print(leg_len, "ll")
	stride = $2 + 0.0
	# print(stride)
	speed=((leg_len == 0.0 || stride==0.0) ? 0.0: ((stride / leg_len)-1) * sqrt(leg_len * 9.8))
	print(speed, $1)
}
' ds1.csv ds2.csv  | sort -nr -k 3 | awk '{print($2, $3)}'
