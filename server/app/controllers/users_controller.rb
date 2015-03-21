class UsersController < ApplicationController
	def new
	end

	def edit
	end

	def create
		@user = User.new(user_params)

		if @user.save
			session[:user_id] = @user.id
			redirect_to "/"
		else
			redirect_to :back
		end
	end

	def update
	end

	def destroy
	end

	private
	def user_params
		params.require(:user).permit(:email, :password, :password_confirmation)
	end
end
