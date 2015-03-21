class User < ActiveRecord::Base
	# Set uniqueness of the user
	validates_uniqueness_of :email

	# We need a password hash
	has_secure_password

	# Questions
	has_many :questions

	#Answers
	has_many :answers

end
