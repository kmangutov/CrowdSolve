class UsersController < ApplicationController
	skip_before_action :verify_authenticity_token

	def new
	end

	def edit
	end

	def create
		@user = User.new(user_params)

		if @user.save
			#session[:user_id] = @user.id
			return render json: {"message" => "success"}
		else
			return render json: {"message" => "error"}
		end
	end

	def update
	end

	def destroy
	end

	private
	def user_params
		params.require(:user).permit(:email, :password, :password_confirmation) if params[:user]
	end
end
