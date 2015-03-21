class AnswersController < ApplicationController
	def index
	end

	def show
	end

	def new
	end

	def edit
	end

	def create
		# Post /answers
		# params: user_id - user id
		# params: quesiton_id - question id
		# params: answer - integer value for answer

		@user = User.find(answer_params[:user_id])
		@q = Question.find(answer_params[:question_id])

		# make the associations and answer
		@answer = @user.answers.create()
		@q.answers << @answer

		#copy the answer
		@answer.update_attribute(:answer, answer_params[:answer])

		redirect_to "/"

	end

	def update
	end

	def destroy
	end

	private
	# Never trust parameters from the scary internet, only allow the white list through.
	def answer_params
		params.require(:answer).permit(:answer, :user_id, :question_id)
	end
end
