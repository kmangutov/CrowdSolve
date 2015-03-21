class QuestionsController < ApplicationController
	def index
	end

	def show
	end

	def new
	end

	def edit
	end

	def create
		@question = Question.new(question_params)

		if @question.save
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
	def question_params
      params.require(:question).permit(:question, :geo)
    end
end
