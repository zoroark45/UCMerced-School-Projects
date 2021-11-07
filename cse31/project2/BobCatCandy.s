.data 
str0: .asciiz "Welcome to BobCat Candy, home to the famous BobCat Bars!"
# Declare any necessary data here
str1: .asciiz "Please enter price of bars:\n"
str2: .asciiz "Please enter number of wrappers returned for one new bar:\n"
str3: .asciiz "Please enter amount of money you have:\n"
str4: .asciiz "You first get "
str5: .asciiz " CatBars!\n"
str6: .asciiz "With $"
str7: .asciiz " you get "
str8: .asciiz " total CatBars!\n"
str9: .asciiz "Then you get "



.text

main:
		#This is the main program.
		#It first asks user to enter the price of each BobCat Bar.
		#It then asks user to enter the number of bar wrappers needed to exchange for a new bar.
		#It then asks user to enter how much money he/she has.
		#It then calls maxBars function to perform calculation of the maximum BobCat Bars the user will receive based on the information entered. 
		#It then prints out a statement about the maximum BobCat Bars the user will receive.
		
		addi $sp, $sp -4	# Feel free to change the increment if you need for space.
		sw $ra, 0($sp)
		# Implement your main here
		
		li	$v0, 4
		la	$a0, str1
		syscall				
		
		li	$v0, 5
		syscall
		move $a0, $v0
		add $s0, $s0, $v0
	
		li	$v0, 4
		la	$a0, str2
		syscall				
		
		li	$v0, 5
		syscall
		move $a0, $v0
		add $s1, $s1, $v0
		
		li	$v0, 4
		la	$a0, str3
		syscall				
		
		li	$v0, 5
		syscall
		move $a0, $v0
		add $s2, $s2, $v0

		add $a0, $zero, $zero
		add $a0, $s0, $zero
		add $a1, $s1, $zero
		add $a2, $s2, $zero


		jal maxBars 	# Call maxBars to calculate the maximum number of BobCat Bars

		# Print out final statement here
		



		j end			# Jump to end of program



maxBars:
		# This function calculates the maximum number of BobCat Bars.
		# It takes in 3 arguments ($a0, $a1, $a2) as n, price, and money. It returns the maximum number of bars
		addi $sp, $sp, -16
		sw $ra, 0($sp)
		
		beq $a2, 0, GT

		sgt $t1, $a2, $a1
		beq  $a2, $a1, ADD
		beq $t1, 0, GT
		

		
		div $t2, $a2, $a0
		
		li	$v0, 4
		la	$a0, str4
		syscall
		
		li $v0, 1
		add $a0, $zero, $t2
		syscall
		
		li	$v0, 4
		la	$a0, str5
		syscall
		
		add $a3, $t2, $zero

		jal newBars 	# Call a helper function to keep track of the number of bars.
		

		
		jr $ra
		# End of maxBars

newBars:
		# This function calculates the number of BobCat Bars a user will receive based on n.
		# It takes in 2 arguments ($a0, $a1) as number of wrappers left so far and n.
		sw $ra, 4($sp)
		
		div $a3, $a3, $a1

		
		beq $a3, $zero, RA
		
		li	$v0, 4
		la	$a0, str9
		syscall
		
		li $v0, 1
		add $a0, $zero, $a3
		syscall
		
		li	$v0, 4
		la	$a0, str5
		syscall
		
		add $t3, $a3, $t3
		
		#beq $a3, 1, RA
		
		sgt $t1, $a3, $a0
		beq $t1, 0, newBars

		
		jr $ra
		# End of newBars

end:

		add $t2, $a0, $zero
		
		li	$v0, 4
		la	$a0, str6
		syscall
		
		li $v0, 1
		add $a0, $a2, $zero
		syscall	
		
		#sw $v0, 0($sp)
		#li $v0, 1
		#lw $a0, 0($sp)		
		#syscall
		
		li	$v0, 4
		la	$a0, str7
		syscall

		li $v0, 1
		add $a0, $zero, $t2
		syscall		
		
		li	$v0, 4
		la	$a0, str8
		syscall		
		
		
		# Terminating the program
		lw $ra, 0($sp)
		addi $sp, $sp 4
		li $v0, 10 
		syscall
		
GT:		sw $ra, 4($sp)
		
		add $a0, $zero, $zero
		
		jr $ra
				
		
RA:	
	sw $ra, 4($sp)
	add $a0, $t3, $t2
	j end
	
ADD:	sw $ra, 4($sp)
	div $t2, $a2, $a0
	add $a0, $t2, $zero
	jr $ra
