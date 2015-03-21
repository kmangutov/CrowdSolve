class QuestionsController < ApplicationController
	def index
	end

	def show
		# Get /questions
		# params: id - user id
		cur_user = User.find(params[:id])
		
		unless cur_user != nil
			return render json: "error"
		end

		n_qu = cur_user.questions
		#@q = Question.limit(1).where("id not in (?)", n_qu.map(&:id))
		@q = Question.first
	end

	def new
	end

	def edit
	end

	def create
		# Post /questions
		# params: user_id - user id

		@user = User.find(question_params[:user_id])
		@q = @user.questions.create(question_params)

		# Answer stuff
		@answer = @q.answers.create()
		@user.answers << @answer

		# Copy the answer
		@answer.update_attribute(:answer, nil)

		redirect_to "/"

	end

	def update
	end

	def destroy
	end

	private
	def question_params
      params.require(:question).permit(:question, :geo, :user_id)
    end
end
