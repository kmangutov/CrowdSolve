class QuestionsController < ApplicationController
	skip_before_action :verify_authenticity_token

	def index
	end

	def show
		# Get /questions
		# params: id - user id
		cur_user = User.find(params[:id])
		
		unless cur_user != nil
			return redner json: {"message" => "error"}
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

		@user = User.find_by(email: question_params[:email])
		#params = {"answers" => question_params[:answers], "geo" => question_params[:geo], "question" => question_params[:question], "user_id" => @user.id}
		@q = @user.questions.create()

		# Give questions value
		@q.update_attribute(:question, question_params[:question])
		@q.update_attribute(:geo, question_params[:geo])

		#@q.update_attribute(:answers, question_params[:answers].to_a)
		#@q.update_attribute(:answers, question_params[:answers])
		@q.answers = Array.new(4,"")
		@q.update_attribute(answers[0], question_params[:answer0])
		@q.update_attribute(answers[1], question_params[:answer1])
		@q.update_attribute(answers[2], question_params[:answer2])
		@q.update_attribute(answers[3], question_params[:answer3])
		@q.save


		# Answer stuff
		@answer = @q.answers.create()
		@user.answers << @answer

		# Copy the answer
		@answer.update_attribute(:answer, nil)

		return render json: {"message" => "success"}

	end

	def update
	end

	def destroy
	end

	def getQuestion
		# get /getquestion
		# params: user_id - user id
		@user = User.find_by(email: question_params[:email])

		# Select Question.question, Question.id, Question.answers from Questions 
		# inner join Answers 
		# on Questions.user_id=Answers.user_id 
		# where Questions.user_id <> @user.id
		Question.answers
		Q - A_U

	end

	private
	def question_params
      params.require(:question).permit(:question, :geo, :email, :answer0, :answer1, :answer2, :answer3)
    end
end
