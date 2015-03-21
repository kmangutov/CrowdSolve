class User < ActiveRecord::Base
	# Set uniqueness of the user
	validates_uniqueness_of :email

	# We need a password hash
	has_secure_password

end
