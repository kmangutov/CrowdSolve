class SessionController < ApplicationController
	protect_from_forgery :except => :create

	def new
	end

	def create 
		@user = User.find_by(email: params[:email])
		if @user && @user.authenticate(params[:password])
			session[:user_id] = @user.id
			return render json: {:message => "success"}
		else 
			return render json: {:message => "fail"}
		end
	end

	def destroy
		session[:user_id] = nil
	end

	def uid 
		@user = User.find_by(email: params[:email])
		return render json: {"id" => @user.id}
	end

end
