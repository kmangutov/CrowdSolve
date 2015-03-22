class DropAnswersFromQuestions < ActiveRecord::Migration
  def change
	  remove_column :questions, :answers, :text
	  add_column :questions, :answer0, :text
	  add_column :questions, :answer1, :text
	  add_column :questions, :answer2, :text
	  add_column :questions, :answer3, :text
  end
end
